package com.springcourse.workshopmongo.resources;

import com.springcourse.workshopmongo.domain.Post;
import com.springcourse.workshopmongo.resources.util.URL;
import com.springcourse.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text); // text vai receber o texto decodificado
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
