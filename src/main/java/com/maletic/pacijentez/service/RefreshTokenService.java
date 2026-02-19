package com.maletic.pacijentez.service;

import com.maletic.pacijentez.model.RefreshToken;
import com.maletic.pacijentez.repository.EmployeeRepository;
import com.maletic.pacijentez.repository.RefreshTokenRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RefreshTokenService {

    RefreshTokenRepository refreshTokenRepository;
    EmployeeRepository employeeRepository;

    @Transactional
    public RefreshToken generateRefreshToken(String username) {
        var employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Employee not found for username: " + username));

        // If a token row already exists for this employee, update it; otherwise create it.
        RefreshToken refreshToken =
            refreshTokenRepository
                .findByEmployee_Id(employee.getId())
                .orElseGet(
                    () -> RefreshToken
                            .builder()
                            .build());

        refreshToken.setEmployee(employee);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(Instant.now().plusMillis(43200000)); // 12 h

        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }


    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Refresh token has expired. Login again.");
        }
        return token;
    }

    @Transactional
    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }

}
