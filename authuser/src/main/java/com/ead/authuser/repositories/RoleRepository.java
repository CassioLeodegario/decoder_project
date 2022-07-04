package com.ead.authuser.repositories;

import com.ead.authuser.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleModel, UUID> {
}
