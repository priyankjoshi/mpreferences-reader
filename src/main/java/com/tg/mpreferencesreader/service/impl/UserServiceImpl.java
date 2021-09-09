package com.tg.mpreferencesreader.service.impl;

import com.tg.mpreferencesreader.dto.UserDto;
import com.tg.mpreferencesreader.entity.User;
import com.tg.mpreferencesreader.repository.UserRepository;
import com.tg.mpreferencesreader.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UserDto> getUsers() {
        List<User> users=userRepository.findAll();
        return mapToDto(users);
    }
    private List<UserDto> mapToDto(List<User> users) {
        return users.stream().map(user->mapper.map(user,UserDto.class)).collect(Collectors.toList());
    }
}
