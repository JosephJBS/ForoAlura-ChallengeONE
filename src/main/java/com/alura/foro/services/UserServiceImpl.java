package com.alura.foro.services;

import com.alura.foro.model.dto.UserDataCreate;
import com.alura.foro.model.dto.UserListData;
import com.alura.foro.model.dto.UserResponse;
import com.alura.foro.model.dto.UserUpdateData;
import com.alura.foro.model.entity.User;
import com.alura.foro.model.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse createUser(UserDataCreate userDataCreate) {
        User user = new User().builder()
                .nombre(userDataCreate.nombre())
                .email(userDataCreate.email())
                .password(userDataCreate.password())
                .status(true)
                .build();
        userRepository.save(user);
        return new UserResponse(user);
    }

    @Override
    public List<UserListData> getAllUsers() {
        List<User> usersFound = userRepository.findAll();
        List<UserListData> allUsers = usersFound.stream()
                .map(user -> new UserListData(user))
                .collect(Collectors.toList());

        return allUsers;
    }

    @Override
    public List<UserListData> getActiveUsers() {
        List<User> usersFound = userRepository.findUserByStatusTrue();
        List<UserListData> allUsers = usersFound.stream()
                .map(user -> new UserListData(user))
                .collect(Collectors.toList());
        return allUsers;
    }

    @Override
    public UserResponse getUserById(int id) {
        Optional<User> userFound= userRepository.findById(id);
        UserResponse userResponse = new UserResponse(userFound.get());
        return userResponse;
    }

    @Override
    public void deleteUserById(int id) {
        Optional<User> userFound= userRepository.findById(id);
        userFound.get().setStatus(false);
        userRepository.save(userFound.get());
    }

    @Override
    public UserResponse udpdateUserData(UserUpdateData updateData) {
        User userFound= userRepository.getReferenceById(updateData.id());

        userFound.setEmail(updateData.email());
        userFound.setNombre(updateData.nombre());
        userFound.setPassword(updateData.password());

        userRepository.save(userFound);
        log.info("Actualiza usuario {}", userFound);
        return new UserResponse(userFound);
    }
}
