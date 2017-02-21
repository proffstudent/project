package su.doma_dachi.lab.dao.Tables;

import su.doma_dachi.lab.domain.Review;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 21.02.2017.
 */
public interface ReviewDao {
    /** Создает новую запись и соответствующий ей объект */
    public Review create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Review read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Review article);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Review article);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Review> getAll() throws SQLException;
}
