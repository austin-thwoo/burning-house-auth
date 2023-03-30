package com.codingfist.burninghouseauth.domain.user.application;

import com.codingfist.burninghouseauth.domain.auth.exception.UserNotFoundException;
import com.codingfist.burninghouseauth.domain.auth.exception.UsernameDuplicatedException;
import com.codingfist.burninghouseauth.domain.user.domain.User;
import com.codingfist.burninghouseauth.domain.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserJpaRepository userJpaRepository;


    public User getUserByUserName(String userName) {
        Optional<User> user = userJpaRepository.findByUsername(userName);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(userName);
        }
        return user.get();
    }


    public boolean usernameOverLap(String userName) {
        boolean exist = userJpaRepository.existsByUsername(userName);

        if (exist) {
            throw new UsernameDuplicatedException(userName);
        }
        return true;
    }

    public User saveUser(User user) {
        return userJpaRepository.save(user);
    }


    public boolean existsUserByUsername(String userName) {
        Optional<User> result = userJpaRepository.existsUserByUsername(userName);
        return result.isPresent();
    }

    public User getUserById(Long userId) {
        Optional<User> user = userJpaRepository.findById(userId);
        if (user.isEmpty()){
            throw new UserNotFoundException(userId);
        }
        return user.get();
    }
}
