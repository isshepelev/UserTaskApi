package ru.isshepelev.usertaskapi.controller;

import org.springframework.data.repository.cdi.Eager;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.usertaskapi.entity.Task;
import ru.isshepelev.usertaskapi.entity.User;
import ru.isshepelev.usertaskapi.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PutMapping("/createUser")
    public User createUser(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping("/users")
    public List<User> listUsers(){
        return service.findAll();
    }

    @GetMapping("/{userId}/tasks")
    public List<Task> getUsersTask(@PathVariable("userId") Long userId){
        User user = service.findById(userId);
        return user.getTasks();
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void delete(@PathVariable Long userId){
        service.delete(userId);
    }
}





















