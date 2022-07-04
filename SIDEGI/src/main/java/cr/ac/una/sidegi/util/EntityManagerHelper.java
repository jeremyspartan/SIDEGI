/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ccarranza
 */
public class EntityManagerHelper {

    private static final EntityManagerHelper SINGLENTON;
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static{
        try{
            SINGLENTON = new EntityManagerHelper();
            emf = Persistence.createEntityManagerFactory("SIDEGIPU");
            em = emf.createEntityManager();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public static EntityManagerHelper getInstance() {
        return SINGLENTON;
    }

    public static EntityManager getManager() {
        if (em == null) {
            emf = Persistence.createEntityManagerFactory("SIDEGIPU");
            em = emf.createEntityManager();
        }
        return em;
    }
}
