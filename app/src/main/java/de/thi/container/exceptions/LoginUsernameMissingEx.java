package de.thi.container.exceptions;

public class LoginUsernameMissingEx extends RuntimeException{
    public LoginUsernameMissingEx(){
        super("login attempt without username");
    }
}
