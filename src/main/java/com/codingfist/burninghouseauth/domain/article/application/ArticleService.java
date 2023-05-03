package com.codingfist.burninghouseauth.domain.article.application;

import com.codingfist.burninghouseauth.domain.user.application.UserService;
import com.codingfist.burninghouseauth.domain.user.domain.User;
import com.codingfist.burninghouseauth.globalCommon.dto.response.ApiResponse;
import localCommon.dto.response.ObjResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
