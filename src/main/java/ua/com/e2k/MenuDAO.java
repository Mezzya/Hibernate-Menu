package ua.com.e2k;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andre on 11/18/2016.
 */
public class MenuDAO {
    private static  MenuDAO mDAO ;
    @PersistenceUnit
    private static EntityManagerFactory emf;
    private static EntityManager em;

    private MenuDAO() {
    }

    public static MenuDAO getInstance()

    {
        if (mDAO == null)
        {
            mDAO = new MenuDAO();
            emf = Persistence.createEntityManagerFactory("JPAMenu");

        }

        return mDAO ;
    }

    public void addMenu(Menu menu)
    {
        em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(menu);
            em.getTransaction().commit();

        }
        finally {
            em.close();
        }


    }



    public List<Menu> getMenuFrom(int from)
    {
        em = emf.createEntityManager();
        List<Menu> list;
        try{
            list = em.createNamedQuery("findAllFrom",Menu.class)
                    .setParameter("from" ,from).getResultList();
        }
        finally {
            em.close();
        }

        return list;
    }

    public List<Menu> getMenuFromDiscount(int from, boolean discount)
    {
        em = emf.createEntityManager();
        List<Menu> list;
        try{
            list = em.createNamedQuery("findAllFromDiscount",Menu.class)
                    .setParameter("from" ,from)
                    .setParameter("discount", discount)
                    .getResultList();
        }
        finally {
            em.close();
        }

        return list;
    }


    public List<Menu>  getMenuToDiscount (int to, boolean discount)
    {
        em = emf.createEntityManager();
        List<Menu> list;
        try{
            list = em.createNamedQuery("findAllToDiscount",Menu.class)
                    .setParameter("to" ,to)
                    .setParameter("discount", discount)
                    .getResultList();
        }
        finally {
            em.close();
        }

        return list;
    }


    public List<Menu> getMenuTo(int to)
    {
        em = emf.createEntityManager();
        List<Menu> list;
        try {
            list = em.createNamedQuery("findAllTo",Menu.class)
                    .setParameter("to" ,to).getResultList();
        }
        finally {
            em.close();
        }

        return list;
    }

    public List<Menu> getMenuFromTo(int from, int to)
    {
        em = emf.createEntityManager();

        List<Menu> list;
        try {
            list = em.createNamedQuery("findAllFromTo",Menu.class)
                    .setParameter("from" ,from)
                    .setParameter("to", to)
                    .getResultList();
        }
        finally {
            em.close();
        }
        return list;
    }


    public List<Menu> getMenuFromToDiscount(int from, int to, boolean discount)
    {
        em = emf.createEntityManager();

        List<Menu> list;
        try{
            list = em.createNamedQuery("findAllFromToDiscount",Menu.class)
                    .setParameter("from" ,from)
                    .setParameter("to", to)
                    .setParameter("discount", discount)

                    .getResultList();

        } finally {
            em.close();
        }
        return list;

    }

    public boolean delById(int id)
    {
        em = emf.createEntityManager();
        try{
            Menu delMenu = em.find(Menu.class, id);
            em.getTransaction().begin();
            if (delMenu==null)
            {
                System.out.println("Нет такого id в базе");
                return false;
            }

            System.out.println("Удаляем "+delMenu);
            em.remove(delMenu);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return true;

    }

    public Menu getById(int id)
    {
        em = emf.createEntityManager();
        Menu result;
        try{
            result = em.find(Menu.class, id);

        } finally {
            em.close();

        }
        return result;


    }

    public List<Menu> getAllMenu()
    {
        em = emf.createEntityManager();
        List<Menu> list;

        try{
            Query q = em.createQuery("from Menu");
            list = q.getResultList();
        } finally {
            em.close();
        }

        return list;

    }

    public List<Menu> getAllDiscount(boolean discount)
    {
        em = emf.createEntityManager();

        List<Menu> list;
        try{
            list = em.createNamedQuery("findAllDiscount",Menu.class)
                    .setParameter("discount", discount)
                    .getResultList();
        } finally {
            em.close();
        }

        return list;

    }




}
