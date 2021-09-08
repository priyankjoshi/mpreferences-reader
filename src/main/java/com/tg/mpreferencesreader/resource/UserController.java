package com.tg.mpreferencesreader.resource;

import com.tg.mpreferencesreader.dto.UserDto;
import com.tg.mpreferencesreader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getAllUser(){
       return userService.getUsers();
    }

}
