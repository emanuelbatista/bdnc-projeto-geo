package br.com.ifpb.bdnc.projeto.geo.persistence;

import br.com.ifpb.bdnc.projeto.geo.entities.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DouglasGabriel
 */
public class Persister {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.ifpb.bdnc_projeto-geo_war_1.0-SNAPSHOTPU");

    public static void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static List getAll (){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            List lista = em.createQuery("from Image i").getResultList();
            em.getTransaction().commit();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return null;
    }

}
