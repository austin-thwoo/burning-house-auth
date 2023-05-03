package com.codingfist.burninghouseauth.domain.article.api;

import com.codingfist.burninghouseauth.domain.article.application.ArticleService;
import com.codingfist.burninghouseauth.domain.user.domain.User;
import com.codingfist.burninghouseauth.globalCommon.dto.response.ApiResponse;
import localCommon.dto.response.ObjResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequiredArgsConstructor
@Api(value = "미인증 사용자")
@RequestMapping("/article")
public class ArticleApi {


    private final ArticleService articleService;

    @GetMapping("")
    public  ApiResponse<ObjResponse>  findAll(@AuthenticationPrincipal User principal) {
        return new ApiResponse<>(articleService.findAllPage(principal));
    }


    @GetMapping("/{articleId}")
    public ApiResponse<ObjResponse> findAll(@AuthenticationPrincipal User principal,
                                              @PathVariable(name = "articleId") Long articleId) {

        return new ApiResponse<>(articleService.findById(principal, articleId));

    }
}

