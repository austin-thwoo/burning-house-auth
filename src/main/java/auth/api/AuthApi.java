package auth.api;

import auth.application.AuthService;
import auth.dto.request.UserRegisterCommand;
import auth.dto.response.TokenResponse;
import auth.dto.request.LoginCommand;
import com.codingfist.burninghouseauth.globalCommon.dto.response.ApiResponse;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequiredArgsConstructor
@Api(value = "미인증 사용자")
@RequestMapping("/auth")
public class AuthApi {


    private final AuthService authService;


    @ApiOperation(value = "회원가입")
    @PostMapping
    public ApiResponse<TokenResponse> save(@RequestBody UserRegisterCommand registerCommand) {
        return new ApiResponse<>(authService.register(registerCommand));
    }

    @ApiOperation(value = "로그인", notes = "로그인->토큰발행")
        @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "로그인을 성공했습니다."),
            @io.swagger.annotations.ApiResponse(code = 404, message = "고객 아이디로 정보를 조회할 수 없습니다.\n삭제되거나 없는 고객입니다.")
    })
    @PostMapping("/login")
    public ApiResponse<TokenResponse> login(@RequestBody LoginCommand loginCommand) {
        return new ApiResponse<>(authService.login(loginCommand));
    }

    @ApiOperation(value = "아이디 중복확인 버튼")
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
