package com.turtlevoice.voiceforensic.service;

import com.turtlevoice.voiceforensic.entity.MyRole;
import com.turtlevoice.voiceforensic.entity.MyUser;

import java.util.List;

public interface RegistrationService {
    MyUser createUser(MyUser user, List<MyRole> userRoles);

    boolean checkEmailExists(String email);

    MyRole findByRolename(String rolename);
}
