package com.alura.foro.model.dto;

import com.alura.foro.model.entity.User;

public record UserResponse(
        int id,
        String nombre,
        String email,
        boolean status
) {
    public UserResponse(User user){
        this(user.getId_user(), user.getNombre(), user.getEmail(), user.isStatus());
    }

}
