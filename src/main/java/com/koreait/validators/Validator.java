package com.koreait.validators;

public interface Validator<T> extends ExistValidator{

    void check(T t);
}
