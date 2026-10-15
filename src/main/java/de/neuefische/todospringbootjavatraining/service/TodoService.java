package de.neuefische.todospringbootjavatraining.service;

import de.neuefische.todospringbootjavatraining.dto.TodoDTO;
import de.neuefische.todospringbootjavatraining.model.Todo;
import de.neuefische.todospringbootjavatraining.repository.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
