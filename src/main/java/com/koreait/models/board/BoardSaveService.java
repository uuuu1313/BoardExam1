package com.koreait.models.board;

import com.koreait.controllers.board.BoardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardDao boardDao;
    public void save(BoardForm boardForm){

        boardDao.save(boardForm);

    }

}
