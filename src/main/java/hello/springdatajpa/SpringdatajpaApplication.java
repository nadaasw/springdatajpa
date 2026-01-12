package hello.springdatajpa;

import hello.springdatajpa.domain.Role;
import hello.springdatajpa.domain.User;
import hello.springdatajpa.repository.RoleRepository;
import hello.springdatajpa.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

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
//        User user = userRepository.findByName("nadaa").orElseThrow();
//        System.out.println(user);


        // paging
//        Page<User> users = userRepository.findBy(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "createdAt" )));
//
//        for(User user : users.getContent()) {
//            System.out.println(user);
//        }


        // roleRepository 를 통해 role 가져오기
//        List<Role> roles = roleRepository.findAll();
//        for (Role role : roles) {
//            System.out.println(roles);
//        }


        // user 에서 role까지 출력
        List<User> users = userRepository.findAll();
        for(User user : users) {
            System.out.println(user);
            Set<Role> roles = user.getRoles();
            for(Role role : roles) {
                System.out.println(role);
            }

            System.out.println("-------------------------");
        }
    }
}
