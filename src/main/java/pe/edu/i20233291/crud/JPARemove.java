package pe.edu.i20233291.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i20233291.Main;
import pe.edu.i20233291.entity.Country;

public class JPARemove {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "CTY");

        // eliminar pais
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();

    }
}
