package com.insightleave.authservice.services;

import com.insightleave.authservice.AuthRepository;
import com.insightleave.authservice.dtos.AuthSignUpDto;
import com.insightleave.authservice.entities.AuthEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public AuthEntity signUp(AuthSignUpDto authSignUpDto) {
        AuthEntity authEntity = AuthEntity.builder()
                .email(authSignUpDto.getEmail())
                .password(authSignUpDto.getPassword())
                .role(authSignUpDto.getRole())
                .build();
        return authRepository.save(authEntity);

    }

}
