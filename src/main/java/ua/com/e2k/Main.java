package ua.com.e2k;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by User on 16.11.2016.
 */
public class Main {
    public static void main(String[] args) {
//        Инициализация базы


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAMenu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Menu m1 = new Menu("Шашлык",120,500,false);
        Menu m2 = new Menu("Борщ", 50,200,true);
        Menu m3 = new Menu("Суп", 50,200,true);
        em.persist(m1);
        em.persist(m2);
        em.persist(m3);
        em.getTransaction().commit();

        System.out.println("Cool");




    }
}
