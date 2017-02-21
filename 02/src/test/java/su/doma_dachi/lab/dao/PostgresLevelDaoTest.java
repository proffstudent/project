package su.doma_dachi.lab.dao;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import su.doma_dachi.lab.dao.Tables.LevelDao;
import su.doma_dachi.lab.domain.Level;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by User on 21.02.2017.
 */

class PostgresLevelDaoTest {
    private static final Logger logger = Logger.getLogger(PostgresLevelDaoTest.class);

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    @Test
    void getAll() {
        DaoFactory daoFactory = new PostgresDaoFactory();
        List<Level> list;
        try (Connection connection = (Connection) daoFactory.getContext()) {
            GenericDao levelDao = daoFactory.getDao(connection,Level.class);
            list = levelDao.getAll();
            Assert.assertNotNull("Данные не получены",list);
            Assert.assertTrue("Данные не получены",list.size() > 0);
        } catch (SQLException e) {
            logger.error("Проблема с БД", e);
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

}