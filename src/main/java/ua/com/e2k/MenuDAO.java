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
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(menu);
        em.getTransaction().commit();
        em.close();

    }

    public List<Menu> getMenuOtDo(int intot, int intdo)
    {
        em = emf.createEntityManager();
        List<Menu> list = new ArrayList<Menu>();
        em.getTransaction().begin();
        Query q = em.createQuery("from Menu where price>"+intot+" AND price<"+intdo);


        list = q.getResultList();
        System.out.println("Количество в базе " +list.size());
        em.getTransaction().commit();

        em.close();
        return list;


    }

    public List<Menu> getMenuFrom(int from)
    {
        em = emf.createEntityManager();
        List<Menu> list = new ArrayList<Menu>();
        em.getTransaction().begin();
        list = em.createNamedQuery("findAllFrom",Menu.class)
                .setParameter("from" ,from).getResultList();
        em.close();
        return list;
    }

    public List<Menu> getMenuTo(int to)
    {
        em = emf.createEntityManager();
        List<Menu> list = new ArrayList<Menu>();
        em.getTransaction().begin();
        list = em.createNamedQuery("findAllTo",Menu.class)
                .setParameter("to" ,to).getResultList();
        em.close();
        return list;
    }
    public List<Menu> getMenuFromTo(int from, int to)
    {
        em = emf.createEntityManager();

        List<Menu> list = new ArrayList<Menu>();
        em.getTransaction().begin();
        list = em.createNamedQuery("findAllFromTo",Menu.class)
                .setParameter("from" ,from)
                .setParameter("to", to)
                .getResultList();
        em.close();
        return list;
    }




    public boolean delById(int id)
    {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Menu delMenu = em.find(Menu.class, id);

        if (delMenu==null)
        {
            System.out.println("Нет такого id в базе");
            em.close();
            return false;
        }

        System.out.println("Удаляем "+delMenu);
        em.remove(delMenu);
        em.getTransaction().commit();
//        em.flush();
//        em.flush();

        em.close();
        return true;

    }
    public List<Menu> getAllMenu()
    {
        em = emf.createEntityManager();
        List<Menu> list = new ArrayList<Menu>();
        em.getTransaction().begin();
        Query q = em.createQuery("from Menu");


        list = q.getResultList();
        System.out.println("Количество в базе " +list.size());
        em.getTransaction().commit();

        em.close();
        return list;

    }




}
