package localCommon.config;

import localCommon.config.JwtAuthenticationFilter;
import localCommon.provider.JwtTokenProvider;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomJwtAuthenticationFilter extends JwtAuthenticationFilter {
    public CustomJwtAuthenticationFilter(JwtTokenProvider tokenProvider) {
        super(tokenProvider);
    }
}
