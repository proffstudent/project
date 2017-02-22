package su.doma_dachi.lab.postgres;

import su.doma_dachi.lab.dao.AbstractDao;
import su.doma_dachi.lab.dao.DaoFactory;
import su.doma_dachi.lab.dao.GenericDao;
import su.doma_dachi.lab.dao.PersistException;
import su.doma_dachi.lab.domain.Level;
import su.doma_dachi.lab.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostgresUserDao extends AbstractDao<User,Integer> {

    private class PersistUser extends User {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT idUser, name, lastName, email, login, password, createdAt, updatedAt," +
                "enabled, sex, birth, residence, education, workplace, position, passport, issuedBy," +
                "adrressReg, accessLevel FROM Users";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Users (name, lastName, email, login, password, createdAt, updatedAt," +
                "enabled, sex, birth, residence, education, workplace, position, passport, issuedBy," +
                "adrressReg, accessLevel) \n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Users SET name = ?, lastName = ?, email = ?, login = ?, password = ?, createdAt = ?," +
                " updatedAt = ?, enabled = ?, sex = ?, birth = ?, residence = ?, education = ?, workplace = ?," +
                " position = ?, passport = ?, issuedBy = ?, adrressReg = ?, accessLevel = ? WHERE idUser = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Users WHERE idUser= ?;";
    }

    @Override
    public User create() throws PersistException {
        User user = new User();
        return persist(user);
    }

    @Override
    public User getByPK(int key) throws SQLException, PersistException {
        List<User> list;
        String sql = getSelectQuery();
        sql += " WHERE idUser = ?";
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


    public PostgresUserDao(DaoFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<User> result = new LinkedList<>();
        try {
            while (rs.next()) {
                PostgresUserDao.PersistUser user = new PostgresUserDao.PersistUser();
                user.setId(rs.getInt("idUser"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setCreatedAt(rs.getDate("createdAt"));
                user.setUpdatedAt(rs.getDate("updatedAt"));
                user.setEnabled(rs.getBoolean("enabled"));
                user.setSex(rs.getString("sex"));
                user.setBirth(rs.getDate("birth"));
                user.setResidence(rs.getString("residence"));
                user.setWorkplace(rs.getString("workplace"));
                user.setPosition(rs.getString("position"));
                user.setPassport(rs.getString("passport"));
                user.setIssuedBy(rs.getString("issuedBy"));
                user.setAddressReg(rs.getString("adrressReg"));
                user.setLevel((Level) getDependence(Level.class,rs.getInt("accessLevel")));
                result.add(user);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {
        try {
            int levelId = (object.getLevel() == null || object.getLevel().getId() == null)? -1
                    : object.getLevel().getId();
            statement.setString(1, object.getName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getEmail());
            statement.setString(4, object.getLogin());
            statement.setString(5, object.getPassword());
            statement.setDate(6, (Date) object.getCreatedAt());
            statement.setDate(7, (Date) object.getUpdatedAt());
            statement.setBoolean(8, object.isEnabled());
            statement.setString(9, object.getSex());
            statement.setDate(10, (Date) object.getBirth());
            statement.setString(11, object.getResidence());
            statement.setString(12, object.getEducation());
            statement.setString(13, object.getWorkplace());
            statement.setString(14, object.getPosition());
            statement.setString(15, object.getPassport());
            statement.setString(16, object.getIssuedBy());
            statement.setString(17, object.getAddressReg());
            statement.setInt(18, levelId);
            statement.setInt(19, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {
        try {
            int levelId = (object.getLevel() == null || object.getLevel().getId() == null)? -1
                    : object.getLevel().getId();
            statement.setString(1, object.getName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getEmail());
            statement.setString(4, object.getLogin());
            statement.setString(5, object.getPassword());
            statement.setDate(6, (Date) object.getCreatedAt());
            statement.setDate(7, (Date) object.getUpdatedAt());
            statement.setBoolean(8, object.isEnabled());
            statement.setString(9, object.getSex());
            statement.setDate(10, (Date) object.getBirth());
            statement.setString(11, object.getResidence());
            statement.setString(12, object.getEducation());
            statement.setString(13, object.getWorkplace());
            statement.setString(14, object.getPosition());
            statement.setString(15, object.getPassport());
            statement.setString(16, object.getIssuedBy());
            statement.setString(17, object.getAddressReg());
            statement.setInt(18, levelId);
            statement.setInt(19, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
