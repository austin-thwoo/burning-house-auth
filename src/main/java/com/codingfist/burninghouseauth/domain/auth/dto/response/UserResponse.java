package com.codingfist.burninghouseauth.domain.auth.dto.response;


import com.codingfist.burninghouseauth.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String userName;
    private String role;

    public UserResponse(User user){
        this.id=user.getId();
        this.userName=user.getUsername();
        this.role=user.getRoles().get(0);
//        this.role=new RoleResponse(user.getRoles());
    }
}
