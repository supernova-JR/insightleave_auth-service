package com.insightleave.authservice.repositories;

import com.insightleave.authservice.AuthRepository;
import com.insightleave.authservice.entities.AuthEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AuthRepositoryTests {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AuthRepository authRepository;

    private AuthEntity mockAuthEntity;
    @BeforeEach
    public void insertAuthBeforeTest() {
        mockAuthEntity = AuthEntity.builder()
                .email("leo@gmail.com")
                .password("123456")
                .role("employee")
                .build();
        entityManager.persist(mockAuthEntity);
        entityManager.flush();
    }

    @Test
    public void ableSignUpNewAuth() {
        AuthEntity authEntity = AuthEntity.builder()
                .email("mengyao1227@gmail.com")
                .password("123456")
                .role("employee")
                .build();

        AuthEntity createdUser = authRepository.save(authEntity);

        assertEquals(authEntity.getEmail(),createdUser.getEmail());
        assertEquals(authEntity.getRole(),createdUser.getRole());
    }

    @Test
    public void ableToDeleteAuthByEmail() {
        List<AuthEntity> deletedAuthEntity = authRepository.deleteAuthEntityByEmail(mockAuthEntity.getEmail());
        assertEquals(mockAuthEntity.getEmail(), deletedAuthEntity.get(0).getEmail());
        assertEquals(mockAuthEntity.getRole(), deletedAuthEntity.get(0).getRole());
        assertEquals(mockAuthEntity.getPassword(), deletedAuthEntity.get(0).getPassword());
    }

    @Test
    public void ableFindAuthByEmail() {
        Optional<AuthEntity> foundAuthEntity = authRepository.findAuthEntityByEmail(mockAuthEntity.getEmail());
        assertTrue(foundAuthEntity.isPresent());
        assertEquals(mockAuthEntity.getEmail(), foundAuthEntity.get().getEmail());
        assertEquals(mockAuthEntity.getRole(), foundAuthEntity.get().getRole());
        assertEquals(mockAuthEntity.getPassword(), foundAuthEntity.get().getPassword());
    }

}
