package com.codingfist.burninghouseauth.domain.user.repository;


import com.codingfist.burninghouseauth.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> existsUserByUsername(String userName);
    Boolean existsByUsername(String userName);

    Optional<User> findByUsername(String userName);


}
