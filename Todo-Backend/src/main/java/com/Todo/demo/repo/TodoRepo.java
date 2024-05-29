package com.Todo.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Todo.demo.model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {

}
