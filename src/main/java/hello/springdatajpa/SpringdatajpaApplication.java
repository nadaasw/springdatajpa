package hello.springdatajpa;

import hello.springdatajpa.domain.User;
import hello.springdatajpa.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
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
    private UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        // user 추가
//        User user = new User();
//        user.setName("Jack");
//        user.setEmail("jackahcak@naver.com");
//        user.setPassword("1234");
//        User saveUser = userRepository.save(user);
//        System.out.println(saveUser);


        // user 찾기
//        User user = userRepository.findById(2).orElseThrow();
//        System.out.println(user);
//
//

        // user delete
//        userRepository.deleteById(2);

        // update
//        User user = userRepository.findById(1).orElseThrow();
//        System.out.println(user);
//
//        user.setPassword("3333");


        // query method
        User user = userRepository.findByName("nadaa").orElseThrow();
        System.out.println(user);

    }
}
