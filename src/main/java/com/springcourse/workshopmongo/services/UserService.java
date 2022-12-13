package com.springcourse.workshopmongo.services;

import com.springcourse.workshopmongo.domain.User;
import com.springcourse.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired // Instanciar automaticamente um objeto // injecao de dependencia automatica
    private UserRepository repo;


    public List<User> findAll() { // Metodo responsavel para retornar todos os users do banco
        return repo.findAll();
    }
}
