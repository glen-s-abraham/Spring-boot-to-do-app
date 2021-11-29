package com.glen.todoapp.todo;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	@Autowired
	private  ToDoRepository toDoRepository;
	
	public List<ToDo> getToDos() {
		return toDoRepository.findAll();
	}

	public void addToDo(ToDo todo) {
		 toDoRepository.save(todo);
	}


	public void deleteToDo(int id) {
		toDoRepository.findById(id)
		.orElseThrow(()->new IllegalStateException("Invalid id"));
		toDoRepository.deleteById(id);
	}
	
	@Transactional
	public void updateToDo(int id, String title, String task) {
		ToDo todo = toDoRepository.findById(id)
				.orElseThrow(()->new IllegalStateException("Invalid id"));
	
		if(title!=null && title.length()>0)
			todo.setTitle(title);
		if(task!=null && task.length()>0)
			todo.setTask(task);
	}

}
