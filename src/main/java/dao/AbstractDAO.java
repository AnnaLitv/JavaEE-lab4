package dao;

import src.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AbstractDAO<K,V> implements DAO<K,V> {
    EntityManager entityManager;
    private JPAUtil jpa;

    public String createQuery;
    public String updateQuery;
    public String deleteQuery;
    public String selectAllQuery;
    public String selectByIdQuery;

    public AbstractDAO(){
        jpa = new JPAUtil();
        entityManager = JPAUtil.getEnmanager();
    }
    @Override
    public List<V> selectAll(Class<V> vClass) {
        entityManager.getTransaction().begin();
        String query = "FROM "+vClass.getSimpleName();
        TypedQuery<V> quer = entityManager.createQuery(query, vClass);
        List<V> arrayList = quer.getResultList();
        entityManager.getTransaction().commit();
        return arrayList;
    }
    @Override
    public V getByKey(Class<V> vClass,K key) {
        entityManager.getTransaction().begin();
        V value = entityManager.find(vClass,key);
        entityManager.getTransaction().commit();
        return value;
    }
    @Override
    public void update(V value, K key) {
        entityManager.getTransaction().begin();
        entityManager.merge(value);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Class<V> vClass,K key) {
        entityManager.getTransaction().begin();
        V goodsEntity = entityManager.find(vClass,key);
        entityManager.remove(goodsEntity);
        entityManager.getTransaction().commit();
    }
    @Override
    public void addElement(V value) {
        entityManager.getTransaction().begin();
        entityManager.persist(value);
        entityManager.getTransaction().commit();
    }

}
