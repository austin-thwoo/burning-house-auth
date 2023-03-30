package com.codingfist.burninghouseauth.domain.article.application;

import com.codingfist.burninghouseauth.domain.auth.dto.request.LoginCommand;
import com.codingfist.burninghouseauth.domain.auth.dto.request.TokenDTO;
import com.codingfist.burninghouseauth.domain.auth.dto.request.UserRegisterCommand;
import com.codingfist.burninghouseauth.domain.auth.dto.response.TokenResponse;
import com.codingfist.burninghouseauth.domain.user.application.UserService;
import com.codingfist.burninghouseauth.domain.user.domain.User;
import com.codingfist.burninghouseauth.globalCommon.dto.response.ApiResponse;
import com.codingfist.burninghouseauth.localCommon.dto.response.ObjResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Service
@RequiredArgsConstructor
public class ArticleService {

    private final UserService userService;

    public ObjResponse findAllPage(User principal) {
        User user=userService.getUserById(principal.getId());
        return new ObjResponse(user.getId(),true);
    }

    public ObjResponse findById(User principal, Long articleId) {

        return new ObjResponse();
    }
}
