package com.training.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.training.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();
    private int nextId;
    private static final Logger logger = LogManager.getLogger(UserService.class);

    public UserServiceImpl() {
        super();
        users.add(new User(1, "Alice", "password1", "1234567890"));
        users.add(new User(2, "Bob", "password2", "0987654321"));
        users.add(new User(3, "Charlie", "password3", "5555555555"));
        nextId = users.size() + 1;
    }

    @Override
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getUserId()==id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User addUser(User user) {
        user.setUserId( nextId);
        users.add(user);
        nextId++;
        logger.info("New user added: " + user);
        return user;
    }

    @Override
    public User updateUser(User updatedUser) {
        User user = getUserById(updatedUser.getUserId());
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setMobileNumber(updatedUser.getMobileNumber());
            logger.info("User updated: " + user);
        }
        return user;
    }

    @Override
    public User deleteUser(int id) {
        User user = getUserById(id);
        if (user != null) {
            users.remove(user);
            logger.info("User deleted: " + user);
        }
        return user;
    }

}
