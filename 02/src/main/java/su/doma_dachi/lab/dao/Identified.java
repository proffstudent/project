package su.doma_dachi.lab.dao;

import java.io.Serializable;

/**
 * Интерфейс индентифицируемых объектов
 */
public interface Identified <PK extends Serializable> {
    /**
     * Возвращает идентификатор объекта
     * @return
     */
    public PK getId();
}
