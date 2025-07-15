package app.dao;

import app.model.Region;
import jakarta.persistence.*;

import java.util.List;

public class RegionDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CountryRegionPU");
    private EntityManager em = emf.createEntityManager();

    public void insert(Region region) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(region);
        tx.commit();
    }

    public List<Region> getAll() {
        return em.createQuery("SELECT r FROM Region r", Region.class).getResultList();
    }

    public void update(int id, String newName) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Region region = em.find(Region.class, id);
        if (region != null) {
            region.setRegionName(newName);
            em.merge(region);
        }
        tx.commit();
    }

    public void delete(int id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Region region = em.find(Region.class, id);
        if (region != null) {
            em.remove(region);
        }
        tx.commit();
    }
}