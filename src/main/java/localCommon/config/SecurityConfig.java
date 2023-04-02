package localCommon.config;

import com.codingfist.burninghouseauth.globalCommon.dto.response.ErrorResponse;
import com.codingfist.burninghouseauth.globalCommon.error.model.ErrorCode;
import localCommon.provider.JwtTokenProvider;

import com.google.gson.Gson;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.Filter;
//import javax.servlet.http.HttpServletRequest;
//
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;





@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final ExceptionFilter exceptionFilter;
    private final UserDetailsService userDetailsService;


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()//이거없으면 큰일남
                .antMatchers("/auth/**", "/resource/*").permitAll()
                .antMatchers("/user/**","/shop/**").hasAnyRole("USER")
                .antMatchers("/user/**","//**").hasAnyRole("USER")
                .antMatchers("/manage/**").hasRole("ADMIN")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()

                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), (Class<? extends Filter>) UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore((Filter) exceptionFilter,JwtAuthenticationFilter.class);


    }

    private AccessDeniedHandler accessDeniedHandler() {


        log.info("accessDeniedHandler");

        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            accessDeniedException(httpServletRequest, httpServletResponse);
        };
    }




    private AuthenticationEntryPoint authenticationEntryPoint() {
        log.info("authenticationEntryPoint");

        return (httpServletRequest, httpServletResponse, e) -> {
            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            invalidTokenException(httpServletRequest, httpServletResponse);
        };
    }




    private void accessDeniedException(jakarta.servlet.http.HttpServletRequest httpServletRequest, jakarta.servlet.http.HttpServletResponse httpServletResponse) throws IOException {


        log.info("accessDeniedException");


        PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setContentType("application/json");
        httpServletRequest.setCharacterEncoding("UTF-8");

        final ErrorResponse exception = ErrorResponse.of(ErrorCode.HANDLE_ACCESS_DENIED);

        out.print(new Gson().toJson(exception));
        out.flush();
    }

    private void invalidTokenException(jakarta.servlet.http.HttpServletRequest httpServletRequest, jakarta.servlet.http.HttpServletResponse httpServletResponse) throws IOException {

        log.info("invalidTokenException");


        PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setContentType("application/json");
        httpServletRequest.setCharacterEncoding("UTF-8");

        final ErrorResponse exception = ErrorResponse.of(ErrorCode.HANDLE_INVALID_TOKEN);

        out.print(new Gson().toJson(exception));
        out.flush();
    }
}
