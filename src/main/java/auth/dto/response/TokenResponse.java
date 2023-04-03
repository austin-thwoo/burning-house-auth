package auth.dto.response;


import auth.dto.request.TokenDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenResponse {

    private String token;
    private UserResponse user;
    private RoleResponse role;
    public TokenResponse(TokenDTO dto) {
        this.token = dto.getToken();
        this.user = new UserResponse(dto.getUser());
        this.role = new RoleResponse(dto.getUser().getRoles());


    }

}
