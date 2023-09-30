package com.alura.foro.services;

import com.alura.foro.model.dto.user.UserDataCreate;
import com.alura.foro.model.dto.user.UserListData;
import com.alura.foro.model.dto.user.UserResponse;
import com.alura.foro.model.dto.user.UserUpdateData;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserDataCreate userDataCreate);

    List<UserListData> getAllUsers();

    List<UserListData> getActiveUsers();

    UserResponse getUserById(int id_user);

    void deleteUserById(int id_user);

    UserResponse udpdateUserData(UserUpdateData data);
}
