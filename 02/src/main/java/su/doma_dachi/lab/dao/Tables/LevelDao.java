package su.doma_dachi.lab.dao.Tables;

import su.doma_dachi.lab.domain.Level;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 21.02.2017.
 */
public interface LevelDao {
    /** Создает новую запись и соответствующий ей объект */
    public Level create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Level read(int key) throws SQLException;

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Level article);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Level article);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Level> getAll() throws SQLException;
}
