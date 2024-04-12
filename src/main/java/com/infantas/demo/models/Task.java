package com.infantas.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;


@Entity
@Table(name = Task.Table_name)

public class Task {
    public static final String Table_name = "Task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id",unique = true)
    private Integer id ;
// anotação ManyToOne confugra a interação entra as tabelas do banco de dados onde o usurio pode ter varias tarefas
@ManyToOne
// anotação responsavel por elencar um id quando o usuario realizar a tarefa
@JoinColumn(name = "user_id")
    private User user;

@Column(name = "description", length = 300,nullable = false)
@Size(min =1,max = 300)
private String description;


    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(user, task.user) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, description);
    }
}
