package su.doma_dachi.lab.postgres;

import su.doma_dachi.lab.dao.GenericDao;
import su.doma_dachi.lab.dao.PersistException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 22.02.2017.
 */
public class PostgresUserDao implements GenericDao {
    public PostgresUserDao(PostgresDaoFactory postgresDaoFactory, Connection connection) {
    }

    @Override
    public Object create() throws SQLException, PersistException {
        return null;
    }

    @Override
    public Object persist(Object object) throws SQLException, PersistException {
        return null;
    }

    @Override
    public Object getByPK(int key) throws SQLException, PersistException {
        return null;
    }

    @Override
    public void update(Object object) throws SQLException, PersistException {

    }

    @Override
    public void delete(Object object) throws SQLException, PersistException {

    }

    @Override
    public List getAll() throws SQLException, PersistException {
        return null;
    }
}
