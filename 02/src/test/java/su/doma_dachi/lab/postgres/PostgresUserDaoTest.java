package su.doma_dachi.lab.postgres;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.GenericDao;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Article;
import su.doma_dachi.lab.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by User on 22.02.2017.
 */
class PostgresUserDaoTest {
    private static final Logger logger = Logger.getLogger(PostgresUserDaoTest.class);

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
    @Test
    void getSelectQuery() {
        DaoFactory daoFactory = new PostgresDaoFactory();
        List<User> list;
        try (Connection connection = (Connection) daoFactory.getContext()) {
            GenericDao userDao = daoFactory.getDao(connection,User.class);
            list = userDao.getAll();
            Assert.assertNotNull("Данные не получены 0",list);
            Assert.assertTrue("Данные не получены 1",list.size() > 0);
        } catch (SQLException e) {
            logger.error("Проблема с БД", e);
        } catch (PersistException e) {
            logger.error("Проблема с таблицей", e);
            e.printStackTrace();
        }
    }

}