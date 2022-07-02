package com.ead.course.validation;

import com.ead.course.dtos.CourseDto;
import com.ead.course.enums.UserType;
import com.ead.course.models.UserModel;
import com.ead.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.UUID;


@Component
public class CourseValidator implements Validator {

    @Autowired
    @Qualifier("defaultValidator")
    private Validator validator;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseDto courseDto = (CourseDto) target;
        validator.validate(courseDto, errors);
        if (!errors.hasErrors()) {
            validateUserInstructor(courseDto.getUserInstructor(), errors);
        }

    }

    private void validateUserInstructor(UUID userInstructor, Errors errors) {
        var userModel = userService.findById(userInstructor);
        if (userModel.isEmpty()) {
            errors.rejectValue(
                    "userInstructor",
                    "UserInstructorError",
                    "Instructor not found"
            );
        }else if (userModel.get().getUserType().equals(UserType.STUDENT.toString())) {
            errors.rejectValue(
                    "userInstructor",
                    "UserInstructorError",
                    "User must be INSTRUCTOR or ADMIN"
            );
        }

    }
}
