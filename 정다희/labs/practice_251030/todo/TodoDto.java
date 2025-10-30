package org.example.restexam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.restexam.domain.Todo;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TodoDto {

    private Long id;
    private String todo;
    private boolean done;

    public static Todo fromDto(TodoDto dto) {
        return Todo.builder()
                .id(dto.getId())
                .todo(dto.getTodo())
                .done(dto.isDone())
                .build();
    }

    public static TodoDto fromEntity(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .todo(todo.getTodo())
                .done(todo.isDone())
                .build();
    }
}
