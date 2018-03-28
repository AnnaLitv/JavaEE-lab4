package dao;

import java.util.List;

public interface DAO<K,V> {

    void update(V value, K key);
    void delete(Class<V> vClass, K key);
    V getByKey(Class<V> vClass, K key);
    void addElement(V value);
    List<V> selectAll(Class<V> vClass);
}
