package com.turtlevoice.voiceforensic.repository;

import com.turtlevoice.voiceforensic.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Integer>
{
    Optional<MyUser> findByEmail(String email);
}
