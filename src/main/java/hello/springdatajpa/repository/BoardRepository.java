package hello.springdatajpa.repository;

import hello.springdatajpa.domain.Board;
import hello.springdatajpa.dto.BoardIf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    // JPQL 을 사용할 수 있다.
    // JPQL은 SQL과 모양이 비슷하지만, SQL이 아니다.
    // JPQL은 객체지향 언어이다.
    // JPQL에서 from 뒤에서 있는 것은 엔티티 이름.
    // Board 엔티티들을 조회하라. 엔티티는 결국 table과 관계.
    @Query(value = "select b from Board b join fetch b.user")
    List<Board> getMembers();

    @Query(value = "select count(b) from Board b")
    Long getBoardCount();

    // 관리자가 쓴 글만 목록을 구하는 JPQL을 작성하시오.
    @Query(value = "select b from Board b join fetch b.user u join u.roles r where r.name = :roleName")
    List<Board> getBoards(@Param("roelName") String roleName);


    // 네이티브 sql을 사용할 수도 있다.
    @Query(value = "select b.board_id, b.title, b.content, b.user_id, u.name, b.regDate, b.view_cnt from board b, user u where b.user_id = u.user_id",
    nativeQuery = true)
    List<BoardIf> getBoardsWithNativeQuery();
}
