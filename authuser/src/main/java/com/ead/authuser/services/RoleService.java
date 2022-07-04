package com.ead.authuser.services;

import com.ead.authuser.enums.RoleType;
import com.ead.authuser.models.RoleModel;

import java.util.Optional;

public interface RoleService {

    Optional<RoleModel> findByRoleName(RoleType roleName);

}
