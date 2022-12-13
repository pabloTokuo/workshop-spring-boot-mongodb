package com.springcourse.workshopmongo.repository;

import com.springcourse.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository                            // MongoRepository para gerencia o USER do tipo STRING(ID)
public interface UserRepository extends MongoRepository<User, String> {
}
