package auth.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UserRegisterCommand {
    private  String username;
    private  String password;




    public void setEncodedPassword(String encodedPassword) {
        this.password= encodedPassword;
    }
}
