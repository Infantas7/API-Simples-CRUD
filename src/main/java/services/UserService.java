package services;


import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.TaskRepository;
import repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
  @Autowired
    private UserRepository userRepository;
  @Autowired
    private TaskRepository taskRepository;



  public User findbyid (Integer id) {

      Optional<User> user = this.userRepository.findById(id);
      return user.orElseThrow(()-> new RuntimeException("Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
    }
@Transactional
public User create (User obj){
      obj.setId(null);
      obj = this.userRepository.save(obj);
      this.taskRepository.saveAll(obj.getTasks());
      return obj;
}
@Transactional
public User update (User obj){
     User newobj = findbyid(obj.getId());
     newobj.setPassword(obj.getPassword());


return this.userRepository.save(newobj);
}

public void delete (Integer id){
    findbyid(id);

      this.userRepository.deleteById(id);

}



}
