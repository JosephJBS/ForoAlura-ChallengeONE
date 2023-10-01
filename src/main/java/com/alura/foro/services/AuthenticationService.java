package com.alura.foro.services;

import com.alura.foro.infra.securiry.AuthenticationResponse;
import com.alura.foro.infra.securiry.JwtService;
import com.alura.foro.model.dto.user.DatosAutenticacionUsuario;
import com.alura.foro.model.entity.User;
import com.alura.foro.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    @Autowired
    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;
    @Autowired

    private final JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;



    public AuthenticationResponse authenticate(DatosAutenticacionUsuario request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = userRepository.findByEmail(request.email())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        log.info("Auntenticacion correcta - Se genera token : {} ",jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}
