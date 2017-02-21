package su.doma_dachi.lab.dao.Tables;

import su.doma_dachi.lab.domain.Author;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 21.02.2017.
 */
public interface AuthorDao {
    /** Создает новую запись и соответствующий ей объект */
    public Author create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Author read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Author article);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Author article);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Author> getAll() throws SQLException;
}
