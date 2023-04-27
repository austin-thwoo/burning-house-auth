//package localCommon.config;
//
//
//import jakarta.servlet.DispatcherType;
//import localCommon.provider.JwtTokenProvider;
//
//import lombok.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//
//@RequiredArgsConstructor
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    private final UserDetailsService userDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf().disable().authorizeHttpRequests()
//                .requestMatchers("/auth").permitAll()
//                .and().authorizeHttpRequests().requestMatchers("/user").permitAll()
//                .and().authorizeHttpRequests().requestMatchers("/manager").hasRole("ADMIN")
//                .and().formLogin().and().build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//
//    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((auths) -> auths
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
//        return http.httpBasic().disable().cors().disable().authorizeHttpRequests(request -> request
//                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//                        .requestMatchers("/status", "/images/**", "/view/join", "/auth/join").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .authorizeHttpRequests(authorize -> authorize
//                        .shouldFilterAllDispatcherTypes(false)
//                        .requestMatchers("/", "/auth/**")
//                        .permitAll()
//                        .requestMatchers("/user/**")
//                        .hasRole("USER")
//                        .requestMatchers("/admin/**")
//                        .hasRole("ADMIN")
//                        .anyRequest()
//                        .authenticated())
//                .build();
//    }
//
//
//
//
//}
