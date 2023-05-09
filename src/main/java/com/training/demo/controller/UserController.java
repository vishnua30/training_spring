package com.training.demo.controller;


import com.training.demo.dto.UserResponseDto;
import com.training.demo.dto.UserResponseDto.ResponseStatus;
import com.training.demo.entity.User;
import com.training.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public UserResponseDto getUsers() {
        List<User> users = userService.getUsers();

        UserResponseDto response = new UserResponseDto();
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setResponseCode(HttpStatus.OK);
        response.setDataSize(users.size());
        response.setData(users);

        
        
        return response;
    }

    @PostMapping("/users")
    public UserResponseDto addUser(@RequestBody User user) {
        User addedUser = userService.addUser(user);
        List<User> users = new ArrayList<User>();
        users.add(addedUser);
        UserResponseDto response = new UserResponseDto();
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setResponseCode(HttpStatus.CREATED);
        response.setData(users);

        return response;
    }

    @PutMapping("/users/{id}")
    public UserResponseDto updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User user = userService.getUserById(id);
        List<User> users = new ArrayList<User>();
        UserResponseDto response = new UserResponseDto();
		if (user != null) {
			user.setName(updatedUser.getName());
			user.setMobileNumber(updatedUser.getMobileNumber());
			user.setPassword(updatedUser.getPassword());
			
			User updated = userService.updateUser(user);
			users.add(updated);
			response.setResponseStatus(ResponseStatus.SUCCESS);
			response.setResponseCode(HttpStatus.OK);
			response.setData(users);
		} else {
			response.setResponseStatus(ResponseStatus.no_user_found);
			response.setResponseCode(HttpStatus.NOT_FOUND);
		}

        return response;
    }

    @DeleteMapping("/users/{id}")
    public UserResponseDto deleteUser(@PathVariable int id) {
        User deleted = userService.deleteUser(id);
        List<User> users = new ArrayList<User>();
        users.add(deleted);
        UserResponseDto response = new UserResponseDto();
		if (deleted == null) {
			response.setResponseStatus(ResponseStatus.no_user_found);
			response.setResponseCode(HttpStatus.NOT_FOUND);

		} else {
			response.setData(users);
			response.setResponseStatus(ResponseStatus.SUCCESS);
			response.setResponseCode(HttpStatus.OK);

		}
        return response;
    }

    @ExceptionHandler(Exception.class)
    public UserResponseDto handleAllExceptions(Exception ex) {
        UserResponseDto response = new UserResponseDto();
        response.setResponseStatus(ResponseStatus.FAIL);
        response.setResponseCode(HttpStatus.BAD_REQUEST);

        return response;
    }
}

