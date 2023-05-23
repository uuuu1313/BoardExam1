package com.koreait.tests;

import com.koreait.controllers.board.BoardForm;
import com.koreait.models.board.BoardDao;
import com.koreait.models.board.BoardDeleteService;
import com.koreait.validators.BoardNoExistException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardDeleteServiceTest {

    @Autowired
    private BoardDao boardDao;

    @Autowired
    private BoardDeleteService deleteService;

    private BoardForm getBoardForm(){
        BoardForm boardForm = BoardForm.builder()
                .id(null)
                .subject("제목1")
                .content("내용1")
                .build();

        return boardForm;
    }

    @Test
    @DisplayName("게시글 번호가 존재 하지않으면 BoardNoExistException 발생")
    void checkExistTest(){
        assertThrows(BoardNoExistException.class, () -> {
            BoardForm boardForm = getBoardForm();
            deleteService.delete(boardForm);
        });
    }

    
}
