package com.Todo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Todo.demo.exception.ResourceNotFoundException;
import com.Todo.demo.model.Todo;
import com.Todo.demo.repo.TodoRepo;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepo todoRepo; 
	
	public List<Todo> findAll()
	{
		return todoRepo.findAll();
	}
	
	public Todo findById(Long id)
	{
		return todoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
	}
	
	public Todo createTodo(Todo todo)
	{
		return todoRepo.save(todo);
	}
	
	public void update(Todo todo)
	{
		 todoRepo.save(todo);
	}
	
	 public Todo updateTodo(Long id, Todo TodoDetails) 
	 {
		 Todo todo = findById(id);
		 todo.setTask(TodoDetails.getTask());
		 todo.setDate(TodoDetails.getDate());
		 todo.setDone(TodoDetails.isDone());
		
	     return todoRepo.save(todo);
	    }
	
	public void delete(Long id)
	{
		 Todo todo = findById(id);
		 todoRepo.delete(todo);
	}
	

}
