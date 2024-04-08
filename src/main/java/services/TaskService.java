package services;

import models.Task;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.TaskRepository;

import java.util.Optional;


@Service
public class TaskService {
@Autowired
    private TaskRepository taskRepository;
@Autowired
    private  UserService userService;


public Task findbyid (Integer id){
    Optional<Task> task = this.taskRepository.findById(id);

    return task.orElseThrow(()-> new RuntimeException("Tarefa não encontrada! Id: " + id + ", Tipo: " + Task.class.getName()));

}
@Transactional
public Task create (Task obj){
    User user = this.userService.findbyid(obj.getUser().getId());
    obj.setUser(user);
    obj.setId(null);
    obj= this.taskRepository.save(obj);
    return obj;
}
public Task update (Task obj){
    Task newobj = findbyid(obj.getId());
    newobj.setDescription(obj.getDescription());
return this.taskRepository.save(newobj);
}
public void delete (Integer id){
    findbyid(id);
    this.taskRepository.deleteById(id);
}








}
