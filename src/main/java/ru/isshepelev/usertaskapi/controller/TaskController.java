package ru.isshepelev.usertaskapi.controller;

import org.springframework.web.bind.annotation.*;
import ru.isshepelev.usertaskapi.entity.Task;
import ru.isshepelev.usertaskapi.entity.User;
import ru.isshepelev.usertaskapi.service.TaskService;
import ru.isshepelev.usertaskapi.service.UserService;

@RestController
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }


    @PutMapping("/{userId}/createTask")
    public Task createTask(@PathVariable("userId") Long userId, @RequestBody Task task){
        User user = userService.findById(userId);
        task.setUser(user);
        return taskService.save(task);
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public void deleteTask(@PathVariable("taskId") Long id){
        taskService.delete(id);
    }



}
