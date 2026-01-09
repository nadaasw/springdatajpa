package hello.springdatajpa;

import hello.springdatajpa.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void run(String... args) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();

            // user 추가
//            User user = new User();
//            user.setName("nadaa");
//            user.setEmail("nadaa@ajou.ac.kr");
//            user.setPassword("1234");
//
//            entityManager.persist(user);

            User user = entityManager.find(User.class, 1);

            System.out.println(user);


            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally{
            entityManager.close();
        }

    }
}
