package com.glen.todoapp.todo;


import java.util.List;


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

	public ToDo addToDo(ToDo todo) {
		 return toDoRepository.save(todo);
	}


	public ToDo deleteToDo(Long id) {
		ToDo taskToDelet=toDoRepository.findById(id).orElse(null);
		if(taskToDelet!=null)
			toDoRepository.deleteById(id);
		return taskToDelet;
	}
	
	@Transactional
	public ToDo updateToDo(Long id, String title, String task) {
		ToDo taskToEdit=toDoRepository.findById(id).orElse(null);
		if(title!=null && title.length()>0)
			taskToEdit.setTitle(title);
		if(task!=null && task.length()>0)
			taskToEdit.setTask(task);
		return taskToEdit;
	}

}
