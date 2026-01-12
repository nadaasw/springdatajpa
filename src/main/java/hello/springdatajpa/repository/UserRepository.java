package hello.springdatajpa.repository;

import hello.springdatajpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
    Optional<User> findByNameAndEmail(String name, String email);
    List<User> findByNameOrEmail(String name, String email);
    List<User> findByUserIdBetween(int startId, int endId);
    List<User> findByUserIdLessThan(int userId);


    // where name like ?
    List<User> findByNameLike(String name);

    // where name like 'input%'
    List<User> findByNameStartingWith(String name);

    // where name like '%input%'
    List<User> findByNameContaining(String name);

    // order by name ASC;
    List<User> findByOrderByNameAsc();

    // where name <> ?
    List<User> findByNameNot(String name);

    // where user_id in (.......)
    List<User> findByUserIdIn(Collection<Integer> userIds);


    // select * from user3
    Long countBy();


    // select * from user3 where name Like ?
    Long countByNameLike(String name);


    // where email = ?
    Boolean existsByName(String name);

    // select * from user3 where name = ?
    // select 한 건수 만큼 delete from user3 where name ?
    int deleteByName(String name);


    // 페이징 기법
    Page<User> findBy(Pageable pageable);

    Page<User> findByNameContaining(String name, Pageable pageable);
}
