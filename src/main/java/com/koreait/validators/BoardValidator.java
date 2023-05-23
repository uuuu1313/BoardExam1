package com.koreait.validators;

import com.koreait.controllers.board.BoardForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BoardForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BoardForm boardForm = (BoardForm) target;

        String subject = boardForm.getSubject();
        String content= boardForm.getContent();

        if (subject == null || subject.isBlank()){
            errors.rejectValue("subject", "IncorrectSubject", "#제목을 입력하세요#");
        }

        if (content == null || content.isBlank()){
            errors.rejectValue("content", "InccorectContent", "#내용을 입력하세요#");
        }
    }
}
