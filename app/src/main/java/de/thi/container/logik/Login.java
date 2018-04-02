package de.thi.container.logik;

import de.thi.container.exceptions.LoginUsernameMissingEx;

public class Login {
    public void login(String username, String password){
        if(username.isEmpty()){
            throw new LoginUsernameMissingEx();
        }
    }
}
