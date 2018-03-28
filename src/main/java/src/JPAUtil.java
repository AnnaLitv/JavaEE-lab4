package src;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory enmanager;
    static {
        enmanager = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }
    public static EntityManager getEnmanager() {
        return enmanager.createEntityManager();
    }
    public  void close(){
        enmanager.close();
    }
}
