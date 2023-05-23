package com.koreait.tests;

import com.koreait.controllers.board.BoardForm;
import com.koreait.models.board.BoardDao;
import com.koreait.models.board.BoardDeleteService;
import com.koreait.models.board.BoardUpdateService;
import com.koreait.validators.BoardNoExistException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class BoardUpdateServiceTest {

    @Autowired
    private BoardDao boardDao;

    @Autowired
    private BoardUpdateService updateService;

    private BoardForm getBoardForm(){
        BoardForm boardForm = BoardForm.builder()
                .subject("  ")
                .content(null)
                .build();

        return boardForm;
    }

    @Test
    @DisplayName("값이 null이면 수정 실패")
    void updateRequiredTest(){
        assertDoesNotThrow(() -> {
            BoardForm boardForm = getBoardForm();
            updateService.update(boardForm);
        });
    }

    @Test
    @DisplayName("값이 존재하면이면 수정 성공")
    void updateTest(){
        assertDoesNotThrow(() -> {
            BoardForm boardForm = getBoardForm();
            boardForm.setId(123L);
            boardForm.setSubject("제목1");
            boardForm.setContent("내용1");
            updateService.update(boardForm);
        });
    }


}
