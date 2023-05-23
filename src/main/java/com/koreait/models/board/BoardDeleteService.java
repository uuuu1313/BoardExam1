package com.koreait.models.board;

import com.koreait.controllers.board.BoardForm;
import com.koreait.validators.BoardDeleteValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {

    private final BoardDao boardDao;

    private final BoardDeleteValidator validator;

    public void delete(BoardForm boardForm){
        Long id = boardForm.getId();

        validator.check(boardForm);

        boardDao.delete(id);
    }
}
