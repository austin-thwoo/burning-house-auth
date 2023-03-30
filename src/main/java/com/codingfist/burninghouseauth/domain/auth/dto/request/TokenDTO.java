package com.codingfist.burninghouseauth.domain.auth.dto.request;



import com.codingfist.burninghouseauth.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    private String token;
    private User user;
}
