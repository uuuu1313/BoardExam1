package com.koreait.validators;

public class BoardNoExistException extends RuntimeException{
    public BoardNoExistException(){
        super("#존재하지 않는 게시글입니다#");
    }
}
