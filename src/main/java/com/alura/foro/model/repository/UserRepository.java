package com.alura.foro.model.repository;

import com.alura.foro.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByStatusTrue();

    Optional<User> findByEmail(String email);

}
