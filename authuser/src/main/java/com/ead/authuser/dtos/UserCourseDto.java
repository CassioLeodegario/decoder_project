package com.ead.authuser.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class UserCourseDto {
    private UUID courseId;
    private UUID userId;
}
