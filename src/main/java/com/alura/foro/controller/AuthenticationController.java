package com.alura.foro.controller;

import com.alura.foro.infra.securiry.AuthenticationResponse;
import com.alura.foro.model.dto.user.DatosAutenticacionUsuario;
import com.alura.foro.model.dto.user.UserDataCreate;
import com.alura.foro.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
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

    @PostMapping("/register")
    @Operation(summary = "Registra un usuario")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserDataCreate request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    @Operation(summary = "Autentica un usuario y genera un token para autorizar " +
            "las consultas a los demás endpoints")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody DatosAutenticacionUsuario request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}