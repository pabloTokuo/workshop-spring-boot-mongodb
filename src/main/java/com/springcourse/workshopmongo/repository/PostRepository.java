package com.springcourse.workshopmongo.repository;

import com.springcourse.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'title': { $regex: ?0, $options: '<i>' } }")
    List<Post> findByTitle(String text);

    // Query Methods para buscar titulo com tal texto
    List<Post> findByTitleContainingIgnoreCase(String text);
}
