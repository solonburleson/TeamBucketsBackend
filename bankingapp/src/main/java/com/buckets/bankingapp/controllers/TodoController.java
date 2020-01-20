package com.buckets.bankingapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buckets.bankingapp.exceptions.ResourceNotFoundException;
import com.buckets.bankingapp.models.Todo;
import com.buckets.bankingapp.repositories.TodoRepository;



@RestController
@RequestMapping("/api")
public class TodoController {
	
	@Autowired
    TodoRepository todoRepository;
	
	/***** Get all todos *****/
    @GetMapping("/todos")
    public List<Todo> getAlltodos(){
    	return todoRepository.findAll();
    }
    
    /***** Get single todo *****/
    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable(value="id") Long todoId) {
    	
    	return todoRepository.findById(todoId)
    			.orElseThrow( ()-> new ResourceNotFoundException("Todo", "id", todoId));
    	
    }
    
 	/***** Create a todo *****/
    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
    	return todoRepository.save(todo);
    }
    
 	/***** Update a todo *****/
    @PutMapping("/todos/{id}")
    public Todo updatetodo(@PathVariable(value="id") Long todoId, @Valid @RequestBody Todo todoDetails) {
    	
    	Todo todo = todoRepository.findById(todoId)
    			.orElseThrow( ()-> new ResourceNotFoundException("todo", "id", todoId));
    	
    	// update everything except ID.
    	todo.setDueDate(todoDetails.getDueDate());
    	todo.setPriority(todoDetails.getPriority());
    	todo.setStatus(todoDetails.getStatus());
    	todo.setTodo(todoDetails.getTodo());
    	
    	Todo updatedTodo = todoRepository.save(todo);
    	
    	return updatedTodo;
    }
    
    /***** Delete a todo *****/
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(value="id") Long todoId){
    	
    	Todo todo = todoRepository.findById(todoId)
    			.orElseThrow( ()-> new ResourceNotFoundException("Todo", "id", todoId));
    	
    	todoRepository.delete(todo);
    	
    	return ResponseEntity.ok().build();
    	
    }

}
