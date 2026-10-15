package de.neuefische.todospringbootjavatraining.repository;

import de.neuefische.todospringbootjavatraining.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepo extends MongoRepository<Todo, String> {
}
