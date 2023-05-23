package com.koreait.models.board;

import com.koreait.entities.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardListService {

    private final BoardDao boardDao;


    public List<Board> gets(){

        return boardDao.gets();
    }
}
