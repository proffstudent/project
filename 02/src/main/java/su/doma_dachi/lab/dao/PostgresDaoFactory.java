package su.doma_dachi.lab.dao;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import su.doma_dachi.lab.dao.Tables.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by User on 21.02.2017.

     */
public class PostgresDaoFactory extends DaoFactory {
    private static final Logger logger = Logger.getLogger(su.doma_dachi.lab.dao.PostgresDaoFactory.class);

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    public static final String DRIVER = "org.postgresql.Driver";
    public static final String DBURL = "jdbc:postgresql://127.0.0.1:5432/publications";
    public static final String NAME = "postgres";
    public static final String PASSWORD = "postgres";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBURL, NAME, PASSWORD);
    }

    public PostgresDaoFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.info(e);
        }
    }

    @Override
    public LevelDao getLevelDao() {
        return null;
    }

    @Override
    public UserDao getUserDao() {
        return null;
    }

    @Override
    public ArticleDao getArticleDao() {
        return null;
    }

    @Override
    public ReviewDao getReviewDao() {
        return null;
    }

    @Override
    public AuthorDao getAuthorDao() {
        return null;
    }
}


