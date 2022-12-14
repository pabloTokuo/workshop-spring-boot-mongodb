package com.springcourse.workshopmongo.resources;

import com.springcourse.workshopmongo.domain.User;
import com.springcourse.workshopmongo.dto.UserDTO;
import com.springcourse.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    // ResponseEntity http response
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll(); // vai procurar no banco de dados e guardar na lista
        List<UserDTO> listDto = list.stream().map(UserDTO::new).toList(); // Transformar a lista em uma listaDto
        return ResponseEntity.ok().body(listDto);
    }

}
