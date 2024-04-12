package com.infantas.demo.repositories;

import com.infantas.demo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {



    List<Task> findByUser_id(Integer id);
}
