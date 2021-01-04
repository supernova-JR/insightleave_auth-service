package com.insightleave.authservice;

import com.insightleave.authservice.entities.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthRepository extends JpaRepository<AuthEntity, Long> {
    List<AuthEntity> deleteAuthEntityByEmail(String email);

    Optional<AuthEntity> findAuthEntityByEmail(String email);
}
