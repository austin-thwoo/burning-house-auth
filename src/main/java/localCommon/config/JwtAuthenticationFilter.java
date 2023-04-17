//package localCommon.config;
//
//
//
//import localCommon.provider.JwtTokenProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.GenericFilterBean;
//
//
//import java.io.IOException;
//
//
//
//public class JwtAuthenticationFilter extends GenericFilterBean implements Filter {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws
//            IOException, ServletException {
//
//        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
//
//        if (token != null && jwtTokenProvider.validateToken(token)) {
//
//            Authentication auth = jwtTokenProvider.getAuthentication(token);
//
//            SecurityContextHolder.getContext().setAuthentication(auth);
//
//
//        }
//        filterChain.doFilter(request, response);
//    }
//
//
//}
