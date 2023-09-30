package com.alura.foro.services;

import com.alura.foro.model.dto.UserDataCreate;
import com.alura.foro.model.dto.UserListData;
import com.alura.foro.model.dto.UserResponse;
import com.alura.foro.model.dto.UserUpdateData;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserDataCreate userDataCreate);

    List<UserListData> getAllUsers();

    List<UserListData> getActiveUsers();

    UserResponse getUserById(int id_user);

    void deleteUserById(int id_user);

    UserResponse udpdateUserData(UserUpdateData data);
}
