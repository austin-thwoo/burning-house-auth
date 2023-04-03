package localCommon.config;

import com.codingfist.burninghouseauth.globalCommon.dto.response.ErrorResponse;
import com.codingfist.burninghouseauth.globalCommon.error.model.ErrorCode;
import com.google.gson.Gson;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.FilterChain;

import java.io.IOException;

@Component
public class ExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        try{
            filterChain.doFilter(request,response);
        } catch (EntityNotFoundException ex){


            setErrorResponse(HttpStatus.FORBIDDEN, (HttpServletResponse) response,ex);
        }
    }

    public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex){
        response.setStatus(status.value());
        response.setContentType("application/json");
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.HANDLE_ACCESS_DENIED);
        try{

            Gson gson = new Gson();

            String json = gson.toJson(errorResponse);

            //String json = errorResponse.convertToJson();
            System.out.println(json);
            response.getWriter().write(json);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}