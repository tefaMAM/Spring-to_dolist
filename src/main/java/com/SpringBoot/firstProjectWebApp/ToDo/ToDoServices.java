package com.SpringBoot.firstProjectWebApp.ToDo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class ToDoServices {
	//data set
	private static List<ToDo>todos=new ArrayList<>();//being static shared with all objects of todoservice
	private static int count=0;
	
	static 
	{//data set
		todos.add(new ToDo(++count, "mostafa", "Learn AWS 1", 
				LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(++count, "mostafa", "Learn DevOps 1", 
				LocalDate.now().plusYears(2), false));
		todos.add(new ToDo(++count, "mostafa", "Learn Full Stack Development 1", 
				LocalDate.now().plusYears(3), false));
		todos.add(new ToDo(++count, "ahmed mahmoud", "Learn machine learning 1",
				LocalDate.now().plusYears(2), false));
	}
	//create read update delete
	public List<ToDo> findByUserName(String userName){
		Predicate<? super ToDo>predicat=todo->todo.getUserName().equalsIgnoreCase(userName);
		return todos.stream().filter(predicat).toList();
	}
	

	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++count,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super ToDo>predicate=todo->todo.getId()==id;
		this.todos.removeIf(predicate);
	}
	
	public ToDo findById(int id) {
	    Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(@Valid ToDo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

	
}
