package dao;

import java.util.List;

public interface GenericDao<T,ID> {
    default void save(T t) {
    }
    List<T> getAll();
    void delete(ID id);
    void update(T t);
}

