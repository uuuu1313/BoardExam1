package com.koreait.tests;

import com.koreait.controllers.board.BoardForm;
import com.koreait.models.board.BoardDao;
import com.koreait.models.board.BoardSaveService;
import com.koreait.validators.BoardValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardSaveServiceTest {

    @Autowired
    private BoardDao boardDao;
    @Autowired
    private BoardSaveService saveService;

    @Autowired
    private BoardValidator validator;

    private BoardForm getBoardForm(){
        BoardForm boardForm = BoardForm.builder()
                .subject("제목1")
                .content("내용1")
                .build();

        return boardForm;
    }


    @Test
    @DisplayName("제목과 내용이 있으면 등록 성공")
    void saveSuccessTest(){
        assertDoesNotThrow(() -> {
            BoardForm boardForm = getBoardForm();
            saveService.save(boardForm);
        });
    }

    @Test
    @DisplayName("제목과 내용이 없으면 등록 실패")
    void saveFailTest(){
        assertDoesNotThrow(() -> {
            BoardForm boardForm = getBoardForm();
            boardForm.setSubject(null);
            boardForm.setContent("   ");
            saveService.save(boardForm);
        });
    }




}
