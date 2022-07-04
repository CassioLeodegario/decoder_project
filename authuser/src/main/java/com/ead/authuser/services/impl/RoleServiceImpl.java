package com.ead.authuser.services.impl;

import com.ead.authuser.repositories.RoleRepository;
import com.ead.authuser.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

}
