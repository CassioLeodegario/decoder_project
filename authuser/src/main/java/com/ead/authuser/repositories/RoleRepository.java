package com.ead.authuser.repositories;

import com.ead.authuser.enums.RoleType;
import com.ead.authuser.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleModel, UUID> {

    Optional<RoleModel> findByRoleName(RoleType roleName);
}
