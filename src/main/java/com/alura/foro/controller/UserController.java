package com.alura.foro.controller;

import com.alura.foro.model.dto.user.UserDataCreate;
import com.alura.foro.model.dto.user.UserListData;
import com.alura.foro.model.dto.user.UserResponse;
import com.alura.foro.model.dto.user.UserUpdateData;
import com.alura.foro.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping()
    public ResponseEntity<List<UserListData>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/active")
    public ResponseEntity<List<UserListData>> getActiveUsers() {
        return ResponseEntity.ok(userService.getActiveUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserDataCreate dataCreate) {
        return ResponseEntity.ok(userService.createUser(dataCreate));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserResponse> updateUser(@RequestBody @Valid UserUpdateData updateData){
        return ResponseEntity.ok(userService.udpdateUserData(updateData));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteUSer(@PathVariable int id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }


}
