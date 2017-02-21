package su.doma_dachi.lab.dao;

import su.doma_dachi.lab.dao.Tables.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by User on 21.02.2017.
 */
public interface DaoFactory {
//    public static final int XML = 1;
//    public static final int POSTGRES = 2;

    public Connection getConnection()throws SQLException;
    public LevelDao getLevelDao(Connection connection);
    public UserDao getUserDao(Connection connection);
    public ArticleDao getArticleDao(Connection connection);
    public ReviewDao getReviewDao(Connection connection);
    public AuthorDao getAuthorDao(Connection connection);

    /*public static DaoFactory getDaoFactory(int whichFactory){
        switch (whichFactory){
            case XML:
              //  return new XmlDaoFactory();
            case POSTGRES:
                return new PostgresDaoFactory();
            default:
                return null;
        }
    }*/
}
