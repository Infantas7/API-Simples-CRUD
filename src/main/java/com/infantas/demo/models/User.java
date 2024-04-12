
//Classe respondavel por modelar o usuario no banco de dados.

package com.infantas.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//anotação Entity indica que a classe a seguir se trata de uma tabela no banco de dados
@Entity
@Table (name = User.Table_name)
public class User {
    public interface CreateUser{}
    public interface UpdateUser{}

    public static final String Table_name = "user";

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name = "id",unique = true)
    private Integer id ;


@Column(name = "username" , length = 100, nullable = false, unique = true)

//Anotações responsaveis pelas validações do atributo username, importadas da dependência Spring starter validation do pom.xml
@NotNull (groups = CreateUser.class)
@NotEmpty (groups = CreateUser.class)
@Size(groups = CreateUser.class , min = 2, max = 100)

 private  String username;



@Column(name = "password" , length = 100, nullable = false)
//Anotação NotBlank equivale as anotaçoes NotNull e NotEmpty juntas.
@NotBlank (groups = {CreateUser.class, UpdateUser.class})
@Size(groups = {CreateUser.class, UpdateUser.class} ,min= 8, max = 60)
    private String password;

@OneToMany(mappedBy = "user")
private List<Task> tasks = new ArrayList<>() ;


@JsonIgnore
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
