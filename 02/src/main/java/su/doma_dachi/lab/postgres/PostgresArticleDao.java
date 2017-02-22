package su.doma_dachi.lab.postgres;

import su.doma_dachi.lab.dao.AbstractDao;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Article;
import su.doma_dachi.lab.domain.Level;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PostgresArticleDao extends AbstractDao<Article, Integer> {
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
        sql += " WHERE idArticle = ?";
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


    public PostgresArticleDao(DaoFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
    }

    @Override
    protected List<Article> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Article> result = new LinkedList<>();
        try {
            while (rs.next()) {
                PersistArticle article = new PersistArticle();
                article.setId(rs.getInt("idArticle"));
                article.setTitle(rs.getString("title"));
                article.setSubject(rs.getString("subject"));
                article.setDontPubl(rs.getBoolean("dontpubl"));
                article.setPathArticle(rs.getString("patharticle"));
                article.setPathAnnotRus(rs.getString("pathannotrus"));
                article.setPathAnnotEng(rs.getString("pathannoteng"));
                article.setPathListLiter(rs.getString("pathlistliter"));
                article.setDateSend(rs.getDate("datesend"));
                article.setDateAdoption(rs.getDate("dateadoption"));
                article.setDatePubl(rs.getDate("datepubl"));
                article.setUrl(rs.getString("url"));
                result.add(article);
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
            statement.setString(2, object.getSubject());
            statement.setBoolean(3, object.isDontPubl());
            statement.setString(4, object.getPathArticle());
            statement.setString(5, object.getPathAnnotRus());
            statement.setString(6, object.getPathAnnotEng());
            statement.setString(7, object.getPathListLiter());
            statement.setDate(8, (Date) object.getDateSend());
            statement.setDate(9, (Date) object.getDateAdoption());
            statement.setDate(10, (Date) object.getDatePubl());
            statement.setString(11, object.getUrl());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Article object) throws PersistException {
        try {
            statement.setString(1, object.getTitle());
            statement.setString(2, object.getSubject());
            statement.setBoolean(3, object.isDontPubl());
            statement.setString(4, object.getPathArticle());
            statement.setString(5, object.getPathAnnotRus());
            statement.setString(6, object.getPathAnnotEng());
            statement.setString(7, object.getPathListLiter());
            statement.setDate(8, (Date) object.getDateSend());
            statement.setDate(9, (Date) object.getDateAdoption());
            statement.setDate(10, (Date) object.getDatePubl());
            statement.setString(11, object.getUrl());
            statement.setInt(12, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
