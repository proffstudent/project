package su.doma_dachi.lab.dao;

import su.doma_dachi.lab.dao.Tables.LevelDao;
import su.doma_dachi.lab.domain.Level;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 21.02.2017.
 */
public class PostgresLevelDao implements LevelDao{
    private final Connection connection;

    public PostgresLevelDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Level create() {
        return null;
    }

    @Override
    public Level read(int key) throws SQLException {
        String sql = "SELECT * FROM Levels WHERE id = ?;";
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
    public void update(Level level) {

    }

    @Override
    public void delete(Level level) {

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
