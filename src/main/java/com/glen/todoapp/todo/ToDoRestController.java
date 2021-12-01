package com.glen.todoapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/todo")
public class ToDoRestController {
	
	@Autowired
	private  ToDoService toDoService;
	
	
	@GetMapping
	public List<ToDo> getToDos(){
		return toDoService.getToDos();
	}
	
	@PostMapping
	public ToDo createToDo(@RequestBody ToDo todo) {
		return toDoService.addToDo(todo);
	}
	
	@DeleteMapping(path = "{id}")
	public ToDo deleteToDo(@PathVariable("id") Long id) {
		return toDoService.deleteToDo(id);
	}
	
	@PutMapping(path  = "{id}")
	public ToDo updateToDo(
			@PathVariable("id")Long id,
			@RequestParam(required=false) String title,
			@RequestParam(required=false) String task) {
		return toDoService.updateToDo(id,title,task);
	}
	
	

}
