package com.ead.course.services;

import com.ead.course.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface UserService {

    Page<UserModel> findAll(Specification<UserModel> specification, Pageable pageable);

    UserModel save(UserModel userModel);
}
