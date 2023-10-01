package com.alura.foro.controller;

import com.alura.foro.infra.securiry.AuthenticationResponse;
import com.alura.foro.model.dto.user.DatosAutenticacionUsuario;
import com.alura.foro.model.dto.user.UserDataCreate;
import com.alura.foro.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    /*@PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserDataCreate request
    ) {
        return ResponseEntity.ok(service.register(request));
    }*/

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody DatosAutenticacionUsuario request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}