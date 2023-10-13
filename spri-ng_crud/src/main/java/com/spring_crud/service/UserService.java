package com.spring_crud.service;

import java.util.List;

public interface UserService {
    public List<UserResponse> getAllUser();
    public UserResponse getUser(Integer userId);
    public Integer addUser(UserResponse userResponse);
    public Integer deleteUser(Integer userId);
    public Integer updateUser(UserResponse userResponse);

}
