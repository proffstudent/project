package su.doma_dachi.lab.dao.Tables;

import su.doma_dachi.lab.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 21.02.2017.
 */
public interface UserDao {
    /** Создает новую запись и соответствующий ей объект */
    public User create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public User read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(User article);

    /** Удаляет запись об объекте из базы данных */
    public void delete(User article);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<User> getAll() throws SQLException;
}
