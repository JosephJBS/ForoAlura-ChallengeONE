package com.alura.foro.model.dto.user;

import com.alura.foro.model.entity.User;

public record UserResponse(
        int id,
        String nombre,
        String email,
        boolean status
) {
    public UserResponse(User user){
        this(user.getIdUser(), user.getNombre(), user.getEmail(), user.isStatus());
    }

}
