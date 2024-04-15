package com.infantas.demo.controllers;

import com.infantas.demo.services.TaskService;
import com.infantas.demo.models.Task;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {
  @Autowired
    private TaskService taskService;
@GetMapping("/{id}")
public ResponseEntity<Task> findById (@PathVariable Integer id) {
    Task obj = this.taskService.findbyid(id);
    return ResponseEntity.ok(obj);
}

@GetMapping("/user/{userid}")
public ResponseEntity<List<Task>> findAllByUserId (@PathVariable Integer userid){
     List<Task> tasks = this.taskService.findAllByUserId(userid);
     return  ResponseEntity.ok().body(tasks);
}


    @PostMapping
    @Validated
    public ResponseEntity<Void> create (@Valid @RequestBody Task obj){
        this.taskService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

   @PutMapping("/{id}")
   @Validated
    public ResponseEntity<Void> Update(@Validated @RequestBody Task obj, @PathVariable  Integer id){
    this.taskService.update(obj);
    return ResponseEntity.noContent().build();
   }

   @DeleteMapping("/{id}")
    public  ResponseEntity<Void> Delete(@PathVariable Integer id){
    this.taskService.delete(id);
    return ResponseEntity.noContent().build();
   }

}

