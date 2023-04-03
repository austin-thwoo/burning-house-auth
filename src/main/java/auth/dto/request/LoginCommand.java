package auth.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginCommand {
//    @ApiModelProperty(position =1, notes = "The id")
    private String userName;
//    @ApiModelProperty(position =2, notes  = "The password")
    private String password;
}
