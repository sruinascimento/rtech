package br.com.rtech.main;

import br.com.rtech.model.*;
import br.com.rtech.util.JPAUtil;

import javax.persistence.EntityManager;

public class MainQueryJPAActivityType {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin();

        Question question = entityManager.find(Question.class, 1l);
        Explanation explanation = entityManager.find(Explanation.class, 1l);
        Video video = entityManager.find(Video.class, 1l);

        System.out.println(question);
        System.out.println(explanation);
        System.out.println(video);

        Activity activity = entityManager.find(Activity.class, 1l);
        System.out.println(activity);

        Alternative alternative = entityManager.find(Alternative.class, 1l);
        System.out.println(alternative);



        entityManager.close();
    }
}
