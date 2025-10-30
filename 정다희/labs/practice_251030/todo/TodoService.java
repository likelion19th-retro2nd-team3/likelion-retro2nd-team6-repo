package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.dto.TodoDto;
import org.example.restexam.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoDto> getTodos() {
        return todoRepository.findAll().stream().map(TodoDto::fromEntity).toList();
    }

    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        return TodoDto.fromEntity(todo);
    }

    @Transactional
    public TodoDto createTodo(TodoDto dto) {
        return TodoDto.fromEntity(todoRepository.save(TodoDto.fromDto(dto)));
    }

    @Transactional
    public TodoDto toggleDone(TodoDto dto) {
        Todo todo = todoRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        todo.setDone(!todo.isDone());

        return TodoDto.fromEntity(todo);
    }

    @Transactional
    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo not found");
        }
        todoRepository.deleteById(id);
    }
}
