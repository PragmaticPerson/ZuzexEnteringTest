package com.zuzex.web.controllers;

import com.zuzex.service.models.User;
import com.zuzex.service.models.DTO.UserTokenRequest;
import com.zuzex.service.models.DTO.UserTokenResponse;
import com.zuzex.service.services.JwtTokenUtil;
import com.zuzex.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginRestController {
    private AuthenticationManager authManager;
    private JwtTokenUtil jwtUtil;
    private UserService userService;

    @Autowired
    public LoginRestController(AuthenticationManager authManager, JwtTokenUtil jwtUtil, UserService userService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserTokenRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getName(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            UserTokenResponse response = new UserTokenResponse(user.getName(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}