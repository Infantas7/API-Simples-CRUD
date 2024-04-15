package com.infantas.demo.controllers;

import jakarta.validation.Valid;
import com.infantas.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.infantas.demo.services.UserService;

import java.net.URI;

//Anotação Spring que indica que é uma classe Controller
@RestController
// Anotação Spring que define a rota base para a classe UserController
@RequestMapping("/user")
// Anoptação Spring que indica que a calsse controller em questão valida as informações baseadas nas validações existe nas calsses models
@Validated

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findByid (@PathVariable  Integer id){
       User obj = this.userService.findbyid(id);
               return ResponseEntity.ok().body(obj);
    }
    // anotação Spring que identifica um metodo de inserção de um novo objeto no banco de dados
    @PostMapping
    @Validated(User.CreateUser.class)
    public  ResponseEntity<Void> create(@Valid @RequestBody User obj){
              this.userService.create(obj);
              //linhas reponsaveis por gerar a rota apos a criação de um usuario
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    // anotação Spring que identifica um método de  atualização de um objeto
@PutMapping("/{id}")
@Validated
    public ResponseEntity<Void> update (@Valid @RequestBody User obj, @PathVariable Integer id){
        this.userService.update(obj);
        return ResponseEntity.noContent().build();

}
// anotação Spring que identifica um metodo de exclusão de objeto
@DeleteMapping("/{id}")
public  ResponseEntity<Void> delete (@PathVariable Integer id){
   this.userService.delete(id);
   return ResponseEntity.noContent().build();
}

}
