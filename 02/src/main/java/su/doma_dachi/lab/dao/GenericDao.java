package su.doma_dachi.lab.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 *
 * @param <T>  тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public interface GenericDao<T, PK extends Serializable> {

    /**
     * Создает новую запись и соответствующий ей объект
     */
    public T create() throws SQLException, PersistException;

    /**
     * Создает новую запись, соответствующую объекту object
     */
    public T persist(T object) throws SQLException, PersistException;

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
    public T getByPK(int key) throws SQLException, PersistException;

    /**
     * Сохраняет состояние объекта group в базе данных
     */
    public void update(T object) throws SQLException, PersistException;

    /**
     * Удаляет запись об объекте из базы данных
     */
    public void delete(T object) throws SQLException, PersistException;

    /**
     * Возвращает список объектов соответствующих всем записям в базе данных
     */
    public List<T> getAll() throws SQLException, PersistException;
}

