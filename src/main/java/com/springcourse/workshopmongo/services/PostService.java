package com.springcourse.workshopmongo.services;

import com.springcourse.workshopmongo.domain.Post;
import com.springcourse.workshopmongo.repository.PostRepository;
import com.springcourse.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + (24 * 60 * 60 * 1000)); // 24h
        return repo.fullSearch(text, minDate, maxDate);
    }

}
