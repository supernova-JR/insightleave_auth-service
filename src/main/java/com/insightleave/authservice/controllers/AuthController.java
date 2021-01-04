package com.insightleave.authservice.controllers;

import com.insightleave.authservice.dtos.AuthSignUpDto;
import com.insightleave.authservice.entities.AuthEntity;
import com.insightleave.authservice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthEntity> sighUp(@RequestBody AuthSignUpDto authSignUpDto) {
        AuthEntity createdNewAuthEntity = authService.signUp(authSignUpDto);
        return ResponseEntity.ok(createdNewAuthEntity);
    }
}
