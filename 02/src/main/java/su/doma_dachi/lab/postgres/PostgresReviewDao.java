package su.doma_dachi.lab.postgres;

import su.doma_dachi.lab.dao.AbstractDao;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Article;
import su.doma_dachi.lab.domain.Author;
import su.doma_dachi.lab.domain.Review;
import su.doma_dachi.lab.domain.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PostgresReviewDao extends AbstractDao<Review,Integer> {

    private class PersistReview extends Review {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT idReview, idUser, idArticle, pathReview, dateOfReceipt, dateReview FROM Reviews";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Reviews (idUser, idArticle, pathReview, dateOfReceipt, dateReview) \n" +
                "VALUES (?,?,?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Reviews SET idUser = ?, idArticle = ?, pathReview= ?, dateOfReceipt= ?, " +
                "dateReview = ? WHERE idReview = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Reviews WHERE idReview = ?;";
    }

    @Override
    public Review create() throws PersistException {
        Review review = new Review();
        return persist(review);
    }

    @Override
    public Review getByPK(int key) throws SQLException, PersistException {
        List<Review> list;
        String sql = getSelectQuery();
        sql += " WHERE idReview = ?";
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


    public PostgresReviewDao(DaoFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
    }

    @Override
    protected List<Review> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Review> result = new LinkedList<>();
        try {
            while (rs.next()) {
                PostgresReviewDao.PersistReview review = new PostgresReviewDao.PersistReview();
                review.setId(rs.getInt("idReview"));
                review.setUser((User) getDependence(User.class, rs.getInt("idUser")));
                review.setArticle((Article) getDependence(Article.class, rs.getInt("idArticle")));
                review.setPathReview(rs.getString("pathReview"));
                review.setDateOfReceipt(rs.getDate("dateOfReceipt"));
                review.setDateReview(rs.getDate("dateReview"));
                result.add(review);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Review object) throws PersistException {
        try {
            int userId = (object.getUser() == null || object.getUser().getId() == null)? -1
                    : object.getUser().getId();
            int articleId = (object.getArticle() == null || object.getArticle().getId() == null)? -1
                    : object.getArticle().getId();
            statement.setInt(1, userId);
            statement.setInt(2, articleId);
            statement.setString(3, object.getPathReview());
            statement.setDate(4, (Date) object.getDateOfReceipt());
            statement.setDate(5, (Date) object.getDateReview());
            statement.setInt(6, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Review object) throws PersistException {
        try {
            int userId = (object.getUser() == null || object.getUser().getId() == null)? -1
                    : object.getUser().getId();
            int articleId = (object.getArticle() == null || object.getArticle().getId() == null)? -1
                    : object.getArticle().getId();
            statement.setInt(1, userId);
            statement.setInt(2, articleId);
            statement.setString(3, object.getPathReview());
            statement.setDate(4, (Date) object.getDateOfReceipt());
            statement.setDate(5, (Date) object.getDateReview());
            statement.setInt(6, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
