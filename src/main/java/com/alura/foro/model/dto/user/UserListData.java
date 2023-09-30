package com.alura.foro.model.dto.user;

import com.alura.foro.model.entity.User;

public record UserListData (
        int id,
        String nombre,
        String email,
        boolean status
){
    public UserListData(User user){
        this(user.getId_user(),user.getNombre(),user.getEmail(), user.isStatus());
    }
}
