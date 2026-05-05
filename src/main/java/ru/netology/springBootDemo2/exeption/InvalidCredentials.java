package ru.netology.springBootDemo2.exeption;

public class InvalidCredentials extends RuntimeException {

    public InvalidCredentials(String msg) {
        super(msg);
    }

}
