package com.codingfist.burninghouseauth.domain.auth.application;

import com.codingfist.burninghouseauth.domain.auth.dto.request.LoginCommand;
import com.codingfist.burninghouseauth.domain.auth.dto.request.TokenDTO;
import com.codingfist.burninghouseauth.domain.auth.dto.request.UserRegisterCommand;
import com.codingfist.burninghouseauth.domain.auth.dto.response.TokenResponse;
import com.codingfist.burninghouseauth.domain.auth.exception.UsernameDuplicatedException;
import com.codingfist.burninghouseauth.domain.user.application.UserService;
import com.codingfist.burninghouseauth.domain.user.domain.User;
import com.codingfist.burninghouseauth.domain.user.repository.UserJpaRepository;

import com.codingfist.burninghouseauth.localCommon.provider.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public TokenResponse register(UserRegisterCommand registerCommand) {
        User saved = save(registerCommand);
        TokenDTO dto = new TokenDTO(getToken(saved), saved);
        return new TokenResponse(dto);
    }

    private String getToken(User user) {
        return jwtTokenProvider.createToken(user.getId(), user.getRoles());
    }

    private boolean existUserByUsername(String userName) {
        return userService.usernameOverLap(userName);

    }

    public User save(UserRegisterCommand registerCommand) {
        return place(registerCommand);
    }
    public User place(UserRegisterCommand registerCommand) {
        existUserByUsername(registerCommand.getUsername());
        registerCommand.setEncodedPassword(passwordEncoder.encode(registerCommand.getPassword()));
        User user = User.create(registerCommand);
        user.addUserRole();
        return userService.saveUser(user);

    }


    public TokenResponse login(LoginCommand loginCommand) {

        User user = userService.getUserByUserName(loginCommand.getUserName());
        passwordCheck(loginCommand.getPassword(), user.getPassword());



        String token = jwtTokenProvider.createToken(user.getId(), user.getRoles());


        TokenDTO dto = new TokenDTO(token, user);
        return new TokenResponse(dto);
    }



    private void checkCode(String userEmail, String authentification) {
    }

    private void passwordCheck(String inputPassword, String userPassword) {
//        boolean match = passwordEncoder.matches(inputPassword, userPassword);
//        if (!match) {
//            throw new InvalidPasswordException(inputPassword);
        }



    public boolean usernameOverLap(String userName) {
        return userService.usernameOverLap(userName);
    }
}
