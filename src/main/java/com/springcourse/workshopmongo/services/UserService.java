package com.springcourse.workshopmongo.services;

import com.springcourse.workshopmongo.domain.User;
import com.springcourse.workshopmongo.dto.UserDTO;
import com.springcourse.workshopmongo.repository.UserRepository;
import com.springcourse.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired // Instanciar automaticamente um objeto // injecao de dependencia automatica
    private UserRepository repo;


    public List<User> findAll() { // Metodo responsavel para retornar todos os users do banco
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getName());
    }

}
