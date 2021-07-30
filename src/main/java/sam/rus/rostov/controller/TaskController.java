package sam.rus.rostov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sam.rus.rostov.entity.Task;
import sam.rus.rostov.service.TaskService;

import java.util.List;


@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/main")
    public String getAll() {
        //List<Task> taskList = taskService.getAll();
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/";
    }

}
