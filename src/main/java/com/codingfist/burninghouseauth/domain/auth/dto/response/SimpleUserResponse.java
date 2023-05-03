package com.codingfist.burninghouseauth.domain.auth.dto.response;


import com.codingfist.burninghouseauth.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUserResponse {
    private Long id;
    private String userName;




    public SimpleUserResponse(User user) {
        this.id = user.getId();
        this.userName=user.getUsername();


    }

}
