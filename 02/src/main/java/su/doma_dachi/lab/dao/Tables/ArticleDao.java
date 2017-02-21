package su.doma_dachi.lab.dao.Tables;

import su.doma_dachi.lab.domain.Article;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 21.02.2017.
 */
public interface ArticleDao {

    /** Создает новую запись и соответствующий ей объект */
    public Article create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Article read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Article article);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Article article);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Article> getAll() throws SQLException;
}
