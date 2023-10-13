package com.spring_crud.service;

import com.spring_crud.entity.User;
import com.spring_crud.exception.UserAlreadyExistsException;
import com.spring_crud.exception.UserNotFoundException;
import com.spring_crud.repository.UserRepository;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserResponse> getAllUser() {
        List<User> userList=userRepository.findAll();
        if(userList.isEmpty())
        {
            throw new UserNotFoundException("No User Exists in data base");
        }
        else {
            List<UserResponse> userResponseList=new ArrayList<UserResponse>();
            for (User user:userList)
            {
                UserResponse userResponse=new UserResponse();
                userResponse.setUserAbout(user.getUserAbout());
                userResponse.setUserEmail(user.getUserEmail());
                userResponse.setUserName(user.getUserName());
                userResponse.setUserId(user.getUserId());
                userResponseList.add(userResponse);
            }
            return userResponseList;
        }
    }

    @Override
    public UserResponse getUser(Integer userId) {
        Optional<User> optionalUser=userRepository.findById(userId);
        if(optionalUser.isPresent())
        {
            User user=optionalUser.get();
            UserResponse userResponse=new UserResponse();
            userResponse.setUserAbout(user.getUserAbout());
            userResponse.setUserEmail(user.getUserEmail());
            userResponse.setUserName(user.getUserName());
            userResponse.setUserId(user.getUserId());
            return userResponse;

        }
        else {
            throw new UserNotFoundException("No any user exists with user Id: "+userId);
        }
    }

    @Override
    public Integer addUser(UserResponse userResponse) {
        if (userRepository.existsById(userResponse.getUserId()))
        {
            throw new UserAlreadyExistsException("User with user Id "+userResponse.getUserId()+" already exists");
        }
        else {
            User user=new User();
            user.setUserAbout(userResponse.getUserAbout());
            user.setUserEmail(userResponse.getUserEmail());
            user.setUserName(userResponse.getUserName());
            user.setUserId(userResponse.getUserId());
        User userdb=userRepository.save(user);
        return userdb.getUserId();

        }
    }

    @Override
    public Integer deleteUser(Integer userId) {
        if (userRepository.existsById(userId))
        {
            throw new UserNotFoundException("user with user Id "+userId+"does not exists");
        }
        else {
            userRepository.deleteById(userId);
return userId;
        }

    }

    @Override
    public Integer updateUser(UserResponse userResponse) {
        if (userRepository.existsById(userResponse.getUserId()))
        {

            User user=new User();
            user.setUserAbout(userResponse.getUserAbout());
            user.setUserEmail(userResponse.getUserEmail());
            user.setUserName(userResponse.getUserName());
            user.setUserId(userResponse.getUserId());
            User userdb=userRepository.save(user);
            return userdb.getUserId();
        }
       else {
           throw new UserNotFoundException("user Not found with Id:  "+userResponse.getUserId());
        }
    }
}
