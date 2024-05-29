package com.Todo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Todo.demo.model.Todo;
import com.Todo.demo.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoContrloller {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("") 
	public List<Todo> findAll()
	{
		return todoService.findAll();
	}
	
	@GetMapping("/{id}") 
	public Todo findById(@PathVariable Long id)
	{
		return todoService.findById(id);
	}
	
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable Long id)
	{
		 todoService.delete(id);
	}
	
	@PostMapping("") 
	public Todo createTodo(@RequestBody Todo todo)
	{
		 return todoService.createTodo(todo);
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<Todo> updateTodo(@PathVariable Long id,@RequestBody Todo todo)
	{
		Todo updatedTodo = todoService.updateTodo(id, todo);
        return ResponseEntity.ok(updatedTodo);
	}
	

	        
	    

}
