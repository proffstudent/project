package su.doma_dachi.lab.postgres;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.GenericDao;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Level;
import su.doma_dachi.lab.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 21.02.2017.

     */
public class PostgresDaoFactory implements DaoFactory<Connection> {
    private static final Logger logger = Logger.getLogger(PostgresDaoFactory.class);

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    public static final String DRIVER = "org.postgresql.Driver";
    public static final String DBURL = "jdbc:postgresql://127.0.0.1:5432/publications";
    public static final String NAME = "postgres";
    public static final String PASSWORD = "hH1508985";

    private Map<Class, DaoCreator> creators;
    @Override
    public Connection getContext() throws PersistException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, NAME, PASSWORD);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return  connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class dtoClass) throws PersistException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create(connection);
    }

    public PostgresDaoFactory() {
        try {
            Class.forName(DRIVER);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<Class, DaoCreator>();
        creators.put(Level.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new PostgresLevelDao(PostgresDaoFactory.this, connection);
            }
        });
        creators.put(User.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new PostgresUserDao(PostgresDaoFactory.this, connection);
            }
        });
    }
}


