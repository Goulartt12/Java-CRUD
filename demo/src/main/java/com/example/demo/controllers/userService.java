package com.example.demo.controllers;

import com.example.demo.userRepository.UserRepository;
import com.example.demo.userRepository.userDto;
import com.example.demo.users.Users;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> allUsers(){
        return userRepository.findAll();
    }

    public Users getById(Long id){
        return userRepository.findById(id).get();
    }

    public Users post(userDto userDto){
        Users users = new Users();
        BeanUtils.copyProperties(userDto, users);
        return userRepository.save(users);
    }

    public Users update(userDto userDto, Long id){
        Users users = userRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("User not found"));

        users.setFirst_name(userDto.first_name());
        users.setFirst_name(userDto.last_name());
        users.setEmail(userDto.email());
        users.setNumber(userDto.number());
        users.setPassword(userDto.password());

        return userRepository.save(users);
    }

    public void delete(Long id){
        Users user = userRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("User not found"));

        userRepository.delete(user);
    }
}
