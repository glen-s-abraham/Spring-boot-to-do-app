package com.glen.todoapp.todo;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	private Set<ToDo> toDos;
	
	private ToDo getToDoById(int id) {
		
		Optional<ToDo> obj=this.toDos.stream()
				.filter(todo->todo.getId()==id)
				.findFirst();
		return obj.get();
		
	}
	
	public ToDoService() {
		this.toDos = new HashSet<>();
	}



	public List<ToDo> getToDos() {
		return this.toDos.stream().collect(Collectors.toList());
	}



	public void addToDo(ToDo todo) {
		this.toDos.add(todo);
	}


	public void deleteToDo(int id) {
		ToDo obj = this.getToDoById(id);
		this.toDos.remove(obj);
	}

	public void updateToDo(int id, String title, String task) {
		ToDo todo = this.getToDoById(id);
		if(!todo.equals(null)) {
			if(title!=null && title.length()>0)
				todo.setTitle(title);
			if(task!=null && task.length()>0)
				todo.setTask(task);
		}else {
			throw new IllegalStateException("No object found");
		}
	}

}
