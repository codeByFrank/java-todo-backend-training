package de.neuefische.todospringbootjavatraining.service;

import de.neuefische.todospringbootjavatraining.dto.TodoDTO;
import de.neuefische.todospringbootjavatraining.model.Todo;
import de.neuefische.todospringbootjavatraining.repository.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    public Todo addTodo(TodoDTO todoDTO) {
        Todo todo = new Todo(
                null,
                todoDTO.description(),
                todoDTO.status()
        );

        return todoRepo.save(todo);
    }

    public Optional<Todo> getTodoById(String id) {
        return todoRepo.findById(id);
    }

    public Optional<Todo> updateTodo(String id, TodoDTO todoDTO) {
        Optional<Todo> existingTodo = todoRepo.findById(id);

        if (existingTodo.isEmpty()) {
            return Optional.empty();
        }

        Todo updatedTodo = existingTodo.get()
                .withDescription(todoDTO.description())
                .withStatus(todoDTO.status());

        return Optional.of(todoRepo.save(updatedTodo));
    }
}
