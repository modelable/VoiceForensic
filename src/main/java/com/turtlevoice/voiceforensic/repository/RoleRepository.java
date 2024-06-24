package com.turtlevoice.voiceforensic.repository;

import com.turtlevoice.voiceforensic.entity.MyRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<MyRole, Integer> {
    Optional<MyRole> findByRolename(String rolename);
}