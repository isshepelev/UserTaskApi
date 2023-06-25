package ru.isshepelev.usertaskapi.service;

import org.springframework.stereotype.Service;
import ru.isshepelev.usertaskapi.entity.Task;
import ru.isshepelev.usertaskapi.repository.TaskRepo;

@Service
public class TaskService {

    private final TaskRepo repository;

    public TaskService(TaskRepo repository) {
        this.repository = repository;
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
