package com.buckets.bankingapp.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buckets.bankingapp.models.Todo;
import com.buckets.bankingapp.services.TodoService;



@RestController
@RequestMapping("/api")
public class TodoController {
	
	@Autowired
    TodoService todoService;
	
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    	// MM/dd/YYYY
    	SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, false));
    	
    }
	
	/***** Get all todos *****/
    @GetMapping("/todos")
    public List<Todo> getAlltodos(){
    	return todoService.listAllTodos();
    }
    
    /***** Get single users todo by user id *****/
//    @GetMapping("/todos/{id}")
//    public List<Todo> getUserTodos(Integer id) {
//    	
//    	return todoService.listTodos(id);
//    }
    
 	/***** Create a todo *****/
    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public Todo createTodo(@Valid @RequestBody Todo todo, HttpServletRequest request) {
    	Long userId = new Long(request.getParameter("user_user_id"));;
    	return todoService.addTodo(todo, userId);
    }
    
    @RequestMapping(value = "/todos/{userid}", method = RequestMethod.POST)
    public Todo createTodo(@Valid @RequestBody Todo todo, @PathVariable("userid") Long userId) {
    	return todoService.addTodo(todo, userId);
    }
    
    
 	/***** Update a todo *****/
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable(value="id") Long todoId, @Valid @RequestBody Todo todoDetails) {
    	
    	return todoService.editTodo(todoId, todoDetails);
    }
    
    /***** Delete a todo *****/
    @DeleteMapping("/todos/{id}")
    public Todo deleteTodo(@PathVariable(value="id") Long todoId){
    	
    	return todoService.deleteTodo(todoId);
    	
    }

}
