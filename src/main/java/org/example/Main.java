package org.example;

import org.example.models.Game;
import org.example.models.Review;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        Game game1 = new Game();
        Game game2 = new Game();


        game1.setTitle("Dark Souls");
        game1.setGenre("MMO");
        game1.setPrice(70.0);
        game1.setCreate_at(LocalDate.now());
        game1.setUpdated_at(LocalDate.now());

        game2.setTitle("Stray");
        game2.setGenre("Indie");
        game2.setPrice(0.0);
        game2.setCreate_at(LocalDate.now());
        game2.setUpdated_at(LocalDate.now());

        Review review1 = new Review();
        Review review2 = new Review();

        review1.setGame(game1);
        review1.setComment("Makes me want to kill myself");
        review1.setScore(1);

        review2.setGame(game2);
        review2.setComment("Total acid trip");
        review2.setScore(9);

        transaction.begin();
        entityManager.persist(game1);
        entityManager.persist(game2);
        entityManager.persist(review1);
        entityManager.persist(review2);
        transaction.commit();
        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}