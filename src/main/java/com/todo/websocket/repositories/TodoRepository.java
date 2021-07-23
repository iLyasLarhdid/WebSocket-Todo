package com.todo.websocket.repositories;

import com.todo.websocket.entities.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity,String> {
}
