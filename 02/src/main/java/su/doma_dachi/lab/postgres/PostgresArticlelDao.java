package su.doma_dachi.lab.postgres;

import su.doma_dachi.lab.dao.AbstractDao;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Article;
import su.doma_dachi.lab.domain.Level;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PostgresArticlelDao extends AbstractDao<Article, Integer> {

    private class PersistArticle extends Article {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT idArticle, title, subject, dontpubl, patharticle, pathannotrus, pathannoteng, pathlistliter," +
                "datesend, dateadoption, datepubl, url FROM articles";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Articles (title, subject, dontpubl, patharticle, pathannotrus, pathannoteng, pathlistliter," +
                "datesend, dateadoption, datepubl, url) \n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Articles SET title = ?, subject = ?, dontpubl = ?, patharticle = ?, pathannotrus = ?, " +
                "pathannoteng = ?, pathlistliter = ?, datesend = ?, dateadoption = ?, datepubl = ?," +
                "url = ? WHERE idArticle= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Articles WHERE idArticle= ?;";
    }

    @Override
    public Article create() throws PersistException {
        Article article = new Article();
        return persist(article);
    }

    @Override
    public Article getByPK(int key) throws SQLException, PersistException {
        List<Article> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
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


    public PostgresArticlelDao(DaoFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
    }

    @Override
    protected List<Article> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Article> result = new LinkedList<>();
        try {
            while (rs.next()) {
                PersistArticle group = new PersistArticle();
                group.setId(rs.getInt("idArticle"));
                group.setTitle(rs.getString("title"));
                result.add(group);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Article object) throws PersistException {
        try {
            statement.setString(1, object.getTitle());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Article object) throws PersistException {
        try {
            statement.setString(1, object.getTitle());
            statement.setInt(2, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    public Article read(int key) throws SQLException {
        String sql = "SELECT * FROM Levels WHERE idlevel = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, key);

        ResultSet rs = statement.executeQuery();
        rs.next();
        Article article= new Article();
        article.setId(rs.getInt("idArticle"));
        article.setTitle(rs.getString("Title"));
        return article;
    }

    @Override
    public List<Article> getAll() throws SQLException {
        String sql= "SELECT * FROM Articles;";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Article> list = new ArrayList<>();
        while (rs.next()){
            Article article = new Article();
            article.setId(rs.getInt("idArticle"));
            article.setTitle(rs.getString("Title"));
            list.add(article);
        }
        return list;
    }
}
