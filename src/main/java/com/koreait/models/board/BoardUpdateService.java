package com.koreait.models.board;

import com.koreait.controllers.board.BoardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardUpdateService {

    private final BoardDao boardDao;

    public void update(BoardForm boardForm){

        boardDao.update(boardForm);
    }

}
