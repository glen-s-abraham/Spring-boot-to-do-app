package com.glen.todoapp.todo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "todo_sequence")
	@SequenceGenerator(
			name = "todo_sequence",
			sequenceName = "todo_sequence",
			allocationSize = 1)
	private Long id;
	private String title;
	private String task;
	
	public ToDo() {
		
	}
	
	public ToDo(Long id, String title, String task) {
		this.id = id;
		this.title = title;
		this.task = task;
	}
	
	public ToDo(String title, String task) {
		this.title = title;
		this.task = task;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", title=" + title + ", task=" + task + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDo other = (ToDo) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
