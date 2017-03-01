package su.doma_dachi.lab.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import su.doma_dachi.lab.domain.Level;
import su.doma_dachi.lab.domain.User;
import su.doma_dachi.lab.postgres.PostgresDaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by User on 27.02.2017.
 import org.junit.Assert;
 import org.junit.After;
 import org.junit.Before;
 import org.junit.Test;
 import ru.dokwork.daotalk.domain.Group;
 import ru.dokwork.daotalk.domain.Student;
 import ru.dokwork.daotalk.mysql.MySqlDaoFactory;

 import java.sql.Connection;
 import java.sql.SQLException;

 /**
 * Created by vladimir on 09.03.14.
 */
public class RelationTest {
    private static final DaoFactory<Connection> factory = new PostgresDaoFactory();

    private Connection connection;

    @Before
    public void setUp() throws PersistException, SQLException {
        connection = factory.getContext();
        connection.setAutoCommit(false);
    }

    @After
    public void tearDown() throws SQLException {
        connection.rollback();
        connection.close();
    }

    @Test
    public void testCreate() throws PersistException, SQLException {
        User user = (User) factory.getDao(connection, User.class).create();
        Assert.assertNull("Level is not null.", user.getLevel());

        Level level = new Level();
        user.setLevel(level);
        Assert.assertNotNull("Level is null.", user.getLevel());
    }

    @Test
    public void testPersist() throws PersistException, SQLException {
        User user = new User();
        Level level = (Level) factory.getDao(connection, Level.class).create();
        user.setLevel(level);
        level.setAccess("Administrator");
        user = (User) factory.getDao(connection, User.class).persist(user);
        Assert.assertNotNull("Group is null.", user.getLevel());
        Assert.assertEquals("Wrong level access.", "Administrator", user.getLevel().getAccess());
    }

    @Test
    public void testPersistAll() throws PersistException, SQLException {
        User user = new User();
        user.setLevel(new Level());
        user = (User) factory.getDao(connection, User.class).persist(user);
        Assert.assertNotNull("Group is null.", user.getLevel());
        Assert.assertNotNull("Group.id is null.", user.getLevel().getId());
    }

    @Test
    public void testUpdate() throws PersistException, SQLException {
        User user = (User) factory.getDao(connection, User.class).create();
        user.setLevel(new Level());
        factory.getDao(connection, User.class).update(user);
        Assert.assertNotNull("Group is null.", user.getLevel());
        Assert.assertNotNull("Group.id is null.", user.getLevel().getId());
    }

    @Test
    public void testUpdateAll() throws PersistException, SQLException {
        User user = (User) factory.getDao(connection, User.class).create();
        Level level = (Level) factory.getDao(connection, Level.class).create();
        level.setAccess("Administrator");
        user.setLevel(level);
        factory.getDao(connection, User.class).update(user);
        Assert.assertNotNull("Group is null.", user.getLevel());
        Assert.assertEquals("Wrong level access.", "Administrator", user.getLevel().getAccess());
    }

    @Test
    public void testRead() throws PersistException, SQLException {
        User user = (User) factory.getDao(connection, User.class).create();
        user.setLevel(new Level());
        factory.getDao(connection, User.class).update(user);

        user = (User) factory.getDao(connection, User.class).getByPK(user.getId());
        Assert.assertNotNull("Student is null.", user);
        Assert.assertNotNull("Group is null.", user.getLevel());
    }

    @Test
    public void testDelete() throws PersistException, SQLException {
        User student = (User) factory.getDao(connection, User.class).create();
        student.setLevel(new Level());
        factory.getDao(connection, User.class).update(student);

        Level level = student.getLevel();

        factory.getDao(connection, User.class).delete(student);
        level = (Level) factory.getDao(connection, Level.class).getByPK(level.getId());
        Assert.assertNotNull("Group not found.", level);
    }
}