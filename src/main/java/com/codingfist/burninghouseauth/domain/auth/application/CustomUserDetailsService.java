package com.codingfist.burninghouseauth.domain.auth.application;



import com.codingfist.burninghouseauth.domain.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userPK) throws UsernameNotFoundException {
        com.codingfist.burninghouseauth.domain.user.domain.User user = userJpaRepository.findById(Long.valueOf(userPK)).orElse(null);

        if (user == null) {
            throw new AccessDeniedException(userPK);
        }

        return  User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles().get(0))
                .build();
    }
}