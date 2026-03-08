package com.example.demo.service;

import com.example.demo.payload.requests.*;
import com.example.demo.payload.responses.RegisterResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<RegisterResponse> registerUser(RegisterRequest registerRequest);
    ResponseEntity<?> loginUser(LoginRequest loginRequest);
    ResponseEntity<?> verifyUserRegistration (RegisterVerifyRequest registerVerifyRequest);
    ResponseEntity<?> resendOtp(ForgotPasswordRequest forgotPasswordRequest);
    ResponseEntity<?> verifyOtp(RegisterVerifyRequest registerVerifyRequest);
    ResponseEntity<?> resetPassword(ResetPasswordRequest resetPasswordRequest);
    ResponseEntity<?> myProfile(ForgotPasswordRequest forgotPasswordRequest);
}
