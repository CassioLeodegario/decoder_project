package com.ead.authuser.controllers;

import com.ead.authuser.dtos.InstructorDto;
import com.ead.authuser.enums.RoleType;
import com.ead.authuser.enums.UserType;
import com.ead.authuser.models.RoleModel;
import com.ead.authuser.models.UserModel;
import com.ead.authuser.services.RoleService;
import com.ead.authuser.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @PostMapping("/subscription")
    public ResponseEntity<?> saveSubscriptionInstructor(
            @RequestBody @Valid InstructorDto instructorDto
    ){
        Optional<UserModel> userModelOptional = userService.findById(instructorDto.getUserId());
        if (userModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        RoleModel roleModel = roleService.findByRoleName(RoleType.ROLE_INSTRUCTOR)
                .orElseThrow(() -> new RuntimeException("Error: Role does not exist"));
        var userModel = userModelOptional.get();
        userModel.setUserType(UserType.INSTRUCTOR);
        userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        userModel.getRoles().add(roleModel);
        userService.updateUser(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userModel);


    }

}
