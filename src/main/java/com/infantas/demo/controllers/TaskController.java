package com.infantas.demo.controllers;

import com.infantas.demo.services.TaskService;
import com.infantas.demo.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {
  @Autowired
    private TaskService taskService;
@GetMapping("/{id}")
public ResponseEntity<Task> findById (@PathVariable Integer id){
    Task obj = this.taskService.findbyid(id);
    return ResponseEntity.ok(obj);

}
}
