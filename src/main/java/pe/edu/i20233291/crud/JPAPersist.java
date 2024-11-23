package pe.edu.i20233291.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i20233291.entity.City;
import pe.edu.i20233291.entity.Country;
import pe.edu.i20233291.entity.CountryLanguage;

import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = new Country(
                "CTY", "Gadnis", "South America", "Asia", 525856.0,
                1850, 32150000, 80.00, 700.0, 402513.0,
                "gadnis", "Republica Federal", "Vizcarra", 5,
                "GD", null, null);

        // crear las ciudades
        City ciudad1 = new City("Villa los pollitos", "Los Claveles", 500000, country);
        City ciudad2 = new City("Villa Dorada", "Los dorados", 400000, country);
        City ciudad3 = new City("Villa Maria", "Marina", 300000, country);

        // agregar ciudades al país
        country.setCity(Arrays.asList(ciudad1, ciudad2, ciudad3));

        // crear los lenguajes
        CountryLanguage Leng1 = new CountryLanguage("Español", "S", 81.5, country);
        CountryLanguage Leng2 = new CountryLanguage("Ingles", "N", 25.5, country);

        // agregar lenguajes al país
        country.setCountryLanguages(Arrays.asList(Leng1, Leng2));
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        System.out.println("Country,City and Languages persistidos exitosamente.");
    }
}

