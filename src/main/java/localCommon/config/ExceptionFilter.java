//package localCommon.config;
//
//
//import com.google.gson.Gson;
//
//
//import globalCommon.dto.response.ErrorResponse;
//import globalCommon.error.exception.EntityNotFoundException;
//import globalCommon.error.model.ErrorCode;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class ExceptionFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)  {
//        try{
//            filterChain.doFilter(request,response);
//        } catch (EntityNotFoundException ex){
//
//
//            setErrorResponse(HttpStatus.FORBIDDEN, (HttpServletResponse) response,ex);
//        }
//    }
//
//    public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex){
//        response.setStatus(status.value());
//        response.setContentType("application/json");
//        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.HANDLE_ACCESS_DENIED);
//        try{
//
//            Gson gson = new Gson();
//
//            String json = gson.toJson(errorResponse);
//
//            //String json = errorResponse.convertToJson();
//            System.out.println(json);
//            response.getWriter().write(json);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//
//}