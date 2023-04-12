package auth.application;

import com.codingfist.burninghouseauth.domain.user.domain.User;
import com.codingfist.burninghouseauth.domain.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
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
    public User loadUserByUsername(String userPK) throws UsernameNotFoundException {
        User user = userJpaRepository.findById(Long.valueOf(userPK)).orElse(null);

        if (user == null) {
            throw new AccessDeniedException(userPK);
        }
        return user;
    }
}