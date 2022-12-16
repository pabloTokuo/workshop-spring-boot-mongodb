package com.springcourse.workshopmongo.resources;

import com.springcourse.workshopmongo.domain.Post;
import com.springcourse.workshopmongo.domain.User;
import com.springcourse.workshopmongo.dto.UserDTO;
import com.springcourse.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}")
    // ResponseEntity http response
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {  // id tem que ser o mesmo que o value id por isso @PathVariable
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj)); // converter obj em UserDTO
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        // URI vai pegar o endereco do novo objeto que inserir
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        // Vai retornar resposta vazia com o codigo 201 e com o cabecalho contendo a localizacao do novo recurso criado
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); //no content = codigo 204
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    // ResponseEntity http response
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {  // id tem que ser o mesmo que o value id por isso @PathVariable
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts()); // Endpoint retornando o posts do usuario obj
    }

}
