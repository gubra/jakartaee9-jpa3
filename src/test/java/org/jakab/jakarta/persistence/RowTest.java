package org.jakab.jakarta.persistence;

import org.junit.jupiter.api.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

public class RowTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeAll
    public static void initEntityManager() {
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
    }

    @Test
    public void itShouldCreateEntity() {
        Row row = new Row("jakarta");

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(row);
        tx.commit();
        em.clear();

        Row newRow = em.createQuery("select r from rowf r where r.value = :value", Row.class)
                .setParameter("value", "jakarta").getSingleResult();
        assertNotNull(newRow);
    }

    @AfterAll
    public static void closeEntityManager() {
        Optional.ofNullable(em).ifPresent(EntityManager::close);
        Optional.ofNullable(emf).ifPresent(EntityManagerFactory::close);
    }
}
