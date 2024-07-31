package com.maletic.pacijentez.security;

import com.maletic.pacijentez.dto.AuthRequestDTO;
import com.maletic.pacijentez.dto.JwtResponseDTO;
import com.maletic.pacijentez.dto.RefreshTokenRequestDTO;
import com.maletic.pacijentez.exception.RefreshTokenNotFoundException;
import com.maletic.pacijentez.model.RefreshToken;
import com.maletic.pacijentez.service.JwtService;
import com.maletic.pacijentez.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public JwtResponseDTO authenticate(@RequestBody AuthRequestDTO request) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if(authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            RefreshToken refreshToken = refreshTokenService.generateRefreshToken(request.getUsername());
            return JwtResponseDTO.builder()
                    .accessToken(jwtService.generateToken(userDetails))
                    .refreshToken(refreshToken.getToken())
                    .build();
        }
        else throw new UsernameNotFoundException("Invalid username or password");
    }

    @PostMapping("/refreshToken")
    public JwtResponseDTO refreshToken(@RequestBody RefreshTokenRequestDTO request){
        return refreshTokenService.findByToken(request.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getEmployee)
                .map(userInfo -> {
                    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    String token = jwtService.generateToken(userDetails);
                    return JwtResponseDTO.builder()
                            .accessToken(token)
                            .refreshToken(request.getToken())
                            .build();
                }).orElseThrow(() -> new RefreshTokenNotFoundException("Refresh token does not exist in the database!"));
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logoutUser(@RequestParam String token) {

        refreshTokenService.findByToken(token)
                .ifPresent(foundToken -> refreshTokenService.deleteRefreshToken(foundToken.getToken()));

        SecurityContextHolder.clearContext();
        Map<String, String> response = new HashMap<>();
        response.put("message", "User logged out successfully");
        return ResponseEntity.ok(response);
    }

}