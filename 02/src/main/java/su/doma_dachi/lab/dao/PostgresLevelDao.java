package su.doma_dachi.lab.dao;

import su.doma_dachi.lab.dao.Tables.LevelDao;
import su.doma_dachi.lab.domain.Level;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 21.02.2017.
 */
public class PostgresLevelDao extends AbstractDao <Level, Integer>{

    private class PersistLevel extends Level {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT idlevel, access FROM levels";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO levels (access) \n" +
                "VALUES (?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE levels SET access= ? WHERE idlevel= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM levels WHERE idlevel= ?;";
    }

    @Override
    public Level create() throws PersistException {
        Level level = new Level();
        return persist(level);
    }

    @Override
    public Level getByPK(int key) throws SQLException, PersistException {
        List<Level> list;
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


    public PostgresLevelDao(DaoFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
    }

    @Override
    protected List<Level> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Level> result = new LinkedList<Level>();
        try {
            while (rs.next()) {
                PersistLevel group = new PersistLevel();
                group.setId(rs.getInt("idlevel"));
                group.setAccess(rs.getString("Access"));
                result.add(group);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Level object) throws PersistException {
        try {
            statement.setString(1, object.getAccess());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Level object) throws PersistException {
        try {
            statement.setString(1, object.getAccess());
            statement.setInt(2, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    public Level read(int key) throws SQLException {
        String sql = "SELECT * FROM Levels WHERE idlevel = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, key);

        ResultSet rs = statement.executeQuery();
        rs.next();
        Level level= new Level();
        level.setId(rs.getInt("idLevel"));
        level.setAccess(rs.getString("Access"));
        return level;
    }



    @Override
    public List<Level> getAll() throws SQLException {
        String sql= "SELECT * FROM Levels;";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Level> list = new ArrayList<>();
        while (rs.next()){
            Level level = new Level();
            level.setId(rs.getInt("idLevel"));
            level.setAccess(rs.getString("Access"));
            list.add(level);
        }
        return list;
    }
}
