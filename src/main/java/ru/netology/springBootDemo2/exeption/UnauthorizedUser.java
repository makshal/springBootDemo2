package ru.netology.springBootDemo2.exeption;

public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String msg) {
        super(msg);
    }

}
