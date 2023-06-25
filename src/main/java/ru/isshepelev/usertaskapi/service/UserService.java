package ru.isshepelev.usertaskapi.service;

import org.springframework.stereotype.Service;
import ru.isshepelev.usertaskapi.entity.User;
import ru.isshepelev.usertaskapi.repository.UserRepo;

import java.util.List;

@Service
public class UserService {
    private final UserRepo repository;

    public UserService(UserRepo repository) {
        this.repository = repository;
    }


    public User save(User user) {
        return repository.save(user);
    }

    public User findById(Long userId) {
        return repository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void delete(Long userId) {
        repository.deleteById(userId);
    }
}
