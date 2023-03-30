package com.codingfist.burninghouseauth.domain.auth.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FindPasswordCommand {
    private String userName;

}
