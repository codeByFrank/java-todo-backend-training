package de.neuefische.todospringbootjavatraining.service;

import de.neuefische.todospringbootjavatraining.dto.TodoDTO;
import de.neuefische.todospringbootjavatraining.model.Todo;
import de.neuefische.todospringbootjavatraining.repository.TodoRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepo todoRepo;

    @InjectMocks
    private TodoService todoService;

    @Test
    void getAllTodos_shouldReturnAllTodos() {
        List<Todo> expectedTodos = List.of(
                new Todo("1", "spazieren", "OPEN"),
                new Todo("2", "lernen", "IN_PROGRESS")
        );

        when(todoRepo.findAll()).thenReturn(expectedTodos);

        List<Todo> actualTodos = todoService.getAllTodos();

        assertEquals(expectedTodos, actualTodos);
    }

    @Test
    void addTodo_shouldSaveTodo() {
        TodoDTO todoDTO = new TodoDTO("spazieren", "OPEN");
        Todo expectedTodo = new Todo(null, "spazieren", "OPEN");

        when(todoRepo.save(expectedTodo)).thenReturn(expectedTodo);

        Todo actualTodo = todoService.addTodo(todoDTO);

        assertEquals(expectedTodo, actualTodo);
    }

    @Test
    void getTodoById() {
        Todo expectedTodo = new Todo("1", "spazieren", "OPEN");

        when(todoRepo.findById("1")).thenReturn(Optional.of(expectedTodo));

        Optional<Todo> actualTodo = todoService.getTodoById("1");

        assertEquals(Optional.of(expectedTodo), actualTodo);
    }

    @Test
    void updateTodo() {
        Todo existingTodo = new Todo("1", "spazieren", "OPEN");
        Todo updatedTodo = new Todo("1", "spazieren gehen", "IN_PROGRESS");
        TodoDTO todoDTO = new TodoDTO("spazieren gehen", "IN_PROGRESS");

        when(todoRepo.findById("1")).thenReturn(Optional.of(existingTodo));
        when(todoRepo.save(updatedTodo)).thenReturn(updatedTodo);

        Optional<Todo> actualTodo = todoService.updateTodo("1", todoDTO);

        assertEquals(Optional.of(updatedTodo), actualTodo);
    }

    @Test
    void updateTodo_shouldReturnEmpty_whenTodoDoesNotExist() {

        TodoDTO todoDTO = new TodoDTO("spazieren gehen", "IN_PROGRESS");

        when(todoRepo.findById("999")).thenReturn(Optional.empty());

        Optional<Todo> actualTodo = todoService.updateTodo("999", todoDTO);

        assertEquals(Optional.empty(), actualTodo);
    }

    @Test
    void deleteTodo() {
        when(todoRepo.existsById("1")).thenReturn(true);

        boolean wasDeleted = todoService.deleteTodo("1");

        assertTrue(wasDeleted);
    }

    @Test
    void deleteTodo_shouldReturnFalse_whenTodoDoesNotExist() {
        when(todoRepo.existsById("999")).thenReturn(false);

        boolean wasDeleted = todoService.deleteTodo("999");

        assertFalse(wasDeleted);
    }
}