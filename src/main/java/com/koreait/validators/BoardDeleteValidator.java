package com.koreait.validators;

import com.koreait.controllers.board.BoardForm;
import com.koreait.models.board.BoardDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardDeleteValidator implements Validator<BoardForm>{

    private final BoardDao boardDao;

    @Override
    public void check(BoardForm boardForm) {
        boolean result = boardDao.exists(boardForm.getId());
        existCk(result, new BoardNoExistException());
    }

}
