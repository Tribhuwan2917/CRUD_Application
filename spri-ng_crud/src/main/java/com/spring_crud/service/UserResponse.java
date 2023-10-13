package com.spring_crud.service;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponse {
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userAbout;
}
