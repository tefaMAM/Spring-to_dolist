package com.SpringBoot.firstProjectWebApp.ToDo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//when i do this it assume it is repoistry to takr from h2 db to app
public interface ToDoRepoistery  extends JpaRepository<ToDo, Integer>{
public List<ToDo> findByUserName(String username);
}
