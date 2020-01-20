package com.buckets.bankingapp.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buckets.bankingapp.exceptions.ResourceNotFoundException;
import com.buckets.bankingapp.models.Todo;
import com.buckets.bankingapp.repositories.TodoRepository;

	
	
	
	@Service
	public class TodoService {
		
		@Autowired
		TodoRepository todoRepository;
		 
		// returns all todos 
		public List<Todo> listAllTodos(){
			return todoRepository.findAll();
		}
		
		// return user specific todos 
//		public List<Todo> listTodos(Long id){
//			
//			List<Todo> userTodos = new ArrayList<Todo>();
//			
//			for(Todo todo: todos)
//				if(todo.getUser().equalsIgnoreCase(user)) 
//					userTodos.add(todo);
//			return userTodos;
//		}
		
		// return todo by id
//		public Todo getTodo(Long todoId) {
//			Optional<Todo> tempTodo = todos.stream()
//					.filter(todo->todo.getId() == todoId)
//					.findFirst();
//			return tempTodo.get();
//		}
		
		// add a todo to list
		public Todo addTodo(Todo todo){
			
			
			
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



