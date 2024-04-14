package com.example.demo.controllers;

import com.example.demo.userRepository.UserRepository;
import com.example.demo.userRepository.userDto;
import com.example.demo.users.Users;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {
    @Autowired
    private userService userService;

    @GetMapping
    public List<Users> allUsers(){
        return userService.allUsers();
    }

    @GetMapping("/{id}")
    public Users byId(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public ResponseEntity post(@Valid @RequestBody userDto userDto){
        Users saveusers = userService.post(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveusers);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id ,@RequestBody @Valid userDto userDto){
        Users user = userService.update(userDto, id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
