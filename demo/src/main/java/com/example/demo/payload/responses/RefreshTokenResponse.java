package com.example.demo.payload.responses;

import com.example.demo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshTokenResponse {

    private String accessToken;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

}

