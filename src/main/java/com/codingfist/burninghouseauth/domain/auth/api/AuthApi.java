package com.codingfist.burninghouseauth.domain.auth.api;

import com.codingfist.burninghouseauth.domain.auth.application.AuthService;
import com.codingfist.burninghouseauth.domain.auth.dto.request.UserRegisterCommand;
import com.codingfist.burninghouseauth.domain.auth.dto.response.TokenResponse;
import com.codingfist.burninghouseauth.domain.auth.dto.request.LoginCommand;
import globalCommon.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequiredArgsConstructor
@Tag(name = "미인증 사용자")
@RequestMapping("/auth")
public class AuthApi {


    private final AuthService authService;
    @Operation(summary = "회원가입")
    @PostMapping("/po")
    public ApiResponse<TokenResponse> save(@RequestBody UserRegisterCommand registerCommand) {
        return new ApiResponse<>(authService.register(registerCommand));
    }

    @Operation(summary = "로그인", description = "로그인->토큰발행")
    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "로그인을 성공했습니다."),
//            @ApiResponse(responseCode = "404", description = "고객 아이디로 정보를 조회할 수 없습니다.\n삭제되거나 없는 고객입니다.")
    })
    @PostMapping("/login")
    public ApiResponse<TokenResponse> login(@RequestBody LoginCommand loginCommand) {
        return new ApiResponse<>(authService.login(loginCommand));
    }

    @Operation(summary = "아이디 중복확인 버튼")
    @GetMapping("/overlap")
    public ApiResponse<Boolean> usernameOverLap(@RequestParam String userName) {
        return new ApiResponse<>(authService.usernameOverLap(userName));

    }
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name = "userName",  value = "ID", required = true, dataType = "string", paramType = "form"),
//            @ApiImplicitParam(name = "name", value = "유저 이름", required = true, dataType = "string", paramType = "form"),
//            @ApiImplicitParam(name = "userPhone", value = "유저 전화번호", required = true, dataType = "string", paramType = "form"),
//            @ApiImplicitParam(name = "code", value = "코드", required = false, dataType = "string", paramType = "form")})
//    @ApiOperation(value = "비밀번호 찾기")
//    @PostMapping("/password")
//    public ApiResponse<SimpleUserResponse> sendPasswordCode(@RequestBody FindPasswordCommand findPasswordCommand) {
//        return new ApiResponse<>(authService.passwordModify(findPasswordCommand));
//    }



}
