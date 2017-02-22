package su.doma_dachi.lab.postgres;

import su.doma_dachi.lab.dao.AbstractDao;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Article;
import su.doma_dachi.lab.domain.Author;
import su.doma_dachi.lab.domain.Level;
import su.doma_dachi.lab.domain.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PostgresAuthorDao extends AbstractDao<Author,Integer> {

    private class PersistAuthor extends Author {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT idAuthor, idUser, idArticle FROM Authors";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Authors (idUser, idArticle) \n" +
                "VALUES (?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Authors SET idUser = ?, idArticle = ? WHERE idAuthor = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Authors WHERE idAuthor= ?;";
    }

    @Override
    public Author create() throws PersistException {
        Author author = new Author();
        return persist(author);
    }

    @Override
    public Author getByPK(int key) throws SQLException, PersistException {
        List<Author> list;
        String sql = getSelectQuery();
        sql += " WHERE idAuthor = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new PersistException("Received more than one record.");
        }
        return list.iterator().next();
    }


    public PostgresAuthorDao(DaoFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
    }

    @Override
    protected List<Author> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Author> result = new LinkedList<>();
        try {
            while (rs.next()) {
                PostgresAuthorDao.PersistAuthor author = new PostgresAuthorDao.PersistAuthor();
                author.setId(rs.getInt("idAuthor"));
                author.setUser((User) getDependence(User.class, rs.getInt("idUser")));
                author.setArticle((Article) getDependence(Article.class, rs.getInt("idArticle")));
                result.add(author);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Author object) throws PersistException {
        try {
            int userId = (object.getUser() == null || object.getUser().getId() == null)? -1
                    : object.getUser().getId();
            int articleId = (object.getArticle() == null || object.getArticle().getId() == null)? -1
                    : object.getArticle().getId();
            statement.setInt(1, userId);
            statement.setInt(2, articleId);
            statement.setInt(3, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Author object) throws PersistException {
        try {
            int userId = (object.getUser() == null || object.getUser().getId() == null)? -1
                    : object.getUser().getId();
            int articleId = (object.getArticle() == null || object.getArticle().getId() == null)? -1
                    : object.getArticle().getId();
            statement.setInt(1, userId);
            statement.setInt(2, articleId);
            statement.setInt(3, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
