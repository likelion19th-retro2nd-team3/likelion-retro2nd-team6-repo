package org.example.restexam.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.restexam.dto.TodoDto;
import org.example.restexam.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoDto> list() {
        return todoService.getTodos();
    }

    @PostMapping
    public ResponseEntity<TodoDto> create(@RequestBody TodoDto dto) {
        return ResponseEntity.ok(todoService.createTodo(dto));
    }

    @PatchMapping("/{id}")
    public TodoDto toggle(@PathVariable Long id) {
        TodoDto dto = TodoDto.builder().id(id).build();
        return todoService.toggleDone(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
