package de.neuefische.todospringbootjavatraining.controller;

import de.neuefische.todospringbootjavatraining.dto.TodoDTO;
import de.neuefische.todospringbootjavatraining.model.Todo;
import de.neuefische.todospringbootjavatraining.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo addTodo(@RequestBody TodoDTO todoDTO) {
        return todoService.addTodo(todoDTO);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
}
