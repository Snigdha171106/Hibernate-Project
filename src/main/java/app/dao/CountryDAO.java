package app.dao;

import app.model.Country;
import jakarta.persistence.*;

import java.util.List;

public class CountryDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CountryRegionPU");
    private EntityManager em = emf.createEntityManager();

    public void insert(Country country) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(country);
        tx.commit();
    }

    public List<Country> getAll() {
        return em.createQuery("SELECT c FROM Country c", Country.class).getResultList();
    }

    public void update(String id, String newName) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Country country = em.find(Country.class, id);
        if (country != null) {
            country.setCountryName(newName);
            em.merge(country);
        }
        tx.commit();
    }

    public void delete(String id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Country country = em.find(Country.class, id);
        if (country != null) {
            em.remove(country);
        }
        tx.commit();
    }
}