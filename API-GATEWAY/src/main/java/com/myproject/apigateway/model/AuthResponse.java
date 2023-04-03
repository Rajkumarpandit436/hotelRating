package com.myproject.apigateway.model;

import lombok.*;

import java.util.Collection;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String userid;
    private String refreshToken;
    private String accessToken;
    private long exprireAt;

    private Collection<String> authorities;
}
