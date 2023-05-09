package com.training.demo.service;


import java.util.List;

import com.training.demo.entity.User;

public interface UserService {
    
    User getUserById(int id);
    
    List<User> getUsers();
    
    User addUser(User user);
    
    User updateUser(User updatedUser);
    
    User deleteUser(int id);

}
