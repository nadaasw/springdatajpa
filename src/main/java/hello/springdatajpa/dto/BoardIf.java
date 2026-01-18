package hello.springdatajpa.dto;


import java.time.LocalDateTime;

public interface BoardIf {
    Integer getBoardId();
    String getTitle();
    String getContent();
    Integer getUserId();
    String getName();
    LocalDateTime getRegDate();
    Integer getViewCount();
}


//b.board_id, b.title, b.content, b.user_id, u.name, b.regDate, b.view_cnt