package com.ead.course.services;

import com.ead.course.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Page<UserModel> findAll(Specification<UserModel> specification, Pageable pageable);

    UserModel save(UserModel userModel);

    void delete(UUID userId);

    Optional<UserModel> findById(UUID userId);
}
