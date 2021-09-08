package com.tg.mpreferencesreader.service;

import com.tg.mpreferencesreader.dto.UserDto;
import com.tg.mpreferencesreader.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
