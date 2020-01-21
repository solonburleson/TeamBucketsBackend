package com.buckets.bankingapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buckets.bankingapp.exceptions.ResourceNotFoundException;
import com.buckets.bankingapp.models.Todo;
import com.buckets.bankingapp.models.User;
import com.buckets.bankingapp.repositories.TodoRepository;

	@Service
	public class TodoService {
		
		@Autowired
		TodoRepository todoRepository;
		
		@Autowired
		UserService userService;
		 
		// returns all todos 
		public List<Todo> listAllTodos(){
			return todoRepository.findAll();
		}
		
		
		// add a todo to list
		public Todo addTodo(Todo todo, Long userId){
			User user = userService.getUser(userId);
			todo.setUser(user);
			return todoRepository.save(todo);
			
		}

		// update a todo in the list
		public Todo editTodo(Long todoId, Todo todoDetails){
			
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
		
		// delete a todo
		public Todo deleteTodo(Long todoId){
			
			Todo todo = todoRepository.findById(todoId)
	    			.orElseThrow( ()-> new ResourceNotFoundException("Todo", "id", todoId));
	    	
			
			Todo deletedTodo = todo;
			
			todoRepository.delete(todo);
	
	    	
	    	return deletedTodo;
		}
		
	}



