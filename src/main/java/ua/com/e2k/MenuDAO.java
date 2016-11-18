package ua.com.e2k;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 11/18/2016.
 */
public class MenuDAO {
    private static  MenuDAO mDAO  =new MenuDAO();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAMenu");
    EntityManager em = emf.createEntityManager();

    private MenuDAO() {
    }

    public static MenuDAO getInstance()
    {
        return mDAO ;
    }

    public void addMenu(Menu menu)
    {
        em.getTransaction().begin();
        em.persist(menu);
        em.getTransaction().commit();

    }

    public List<Menu> getAllMenu()
    {
        List<Menu> list = new ArrayList<Menu>();
        em.getTransaction().begin();
        Query q = em.createQuery("from Menu");


        list = q.getResultList();
        em.getTransaction().commit();

        return list;

    }




}
