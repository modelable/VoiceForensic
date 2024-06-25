package com.turtlevoice.voiceforensic.service;

import com.turtlevoice.voiceforensic.entity.MyRole;
import com.turtlevoice.voiceforensic.entity.MyUser;
import com.turtlevoice.voiceforensic.repository.RoleRepository;
import com.turtlevoice.voiceforensic.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // 회원가입 기능에 passwordEncoder가 포함되어 있다.
    @Autowired
    private PasswordEncoder passwordEncoder;

    public MyUser createUser(MyUser user, List<MyRole> userRoles) {
        for (MyRole ur : userRoles) {
            if (roleRepository.findByRolename(ur.getRolename()).isEmpty()) {
                roleRepository.save(ur);
            }
        }

        // generate new Bcrypt hash
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        user.setRoles(userRoles);

        MyUser newUser = userRepository.save(user);

        return newUser;
    }

    public boolean checkEmailExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            return true;
        }

        return false;
    }

    public MyRole findByRolename(String rolename) {
        Optional<MyRole> role = roleRepository.findByRolename(rolename);
        return role.orElseGet(() -> new MyRole(rolename));
    }

}