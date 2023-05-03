package com.codingfist.burninghouseauth.domain.auth.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRegisterCommand {
    private  String username;
    private  String password;




    public void setEncodedPassword(String encodedPassword) {
        this.password= encodedPassword;
    }
}
