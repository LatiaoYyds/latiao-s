package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/addTask")
    public String addTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "add-task";
    }

    @PostMapping("/addTask")
    public String addTaskSubmit(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }
}
