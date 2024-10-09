package com.SpringBoot.firstProjectWebApp.ToDo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class ToDoControllerJpa {

    private final ToDoServices toDoService;
    private ToDoRepoistery todorepoistry;
    
    @Autowired
    public ToDoControllerJpa(ToDoServices toDoService,ToDoRepoistery todorepoistry) {
        this.toDoService = toDoService;
        this.todorepoistry=todorepoistry;
    }

    // Show the list of ToDo items
    @RequestMapping(value = "todo-list", method = RequestMethod.GET)
    public String showToDoList(ModelMap model) {
        String username = userLogedInName();
        //todorepoistry
        List<ToDo> todos = todorepoistry.findByUserName(username);
        model.addAttribute("todos", todos);
        return "todoList";
    }

    private String userLogedInName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    // Delete a ToDo item by its ID
    @RequestMapping("delete-todo")
    public String handleDeleteTodo(@RequestParam int id) {
        todorepoistry.deleteById(id);
        return "redirect:todo-list";
    }

    
    
    
    // Show the form to add a new ToDo item
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new ToDo(0, userLogedInName(), "", LocalDate.now().plusYears(1), false));
        return "addtodo";
    }

    // Handle the submission of the new ToDo item form
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String handleAddTodo(@ModelAttribute("todo") @Valid ToDo newTodo, BindingResult result) {
        if (result.hasErrors()) {
            return "addtodo"; // Return to the form view if there are validation errors
        }
        String username = userLogedInName();
        newTodo.setUserName(username);
        todorepoistry.save(newTodo);
        //toDoService.addTodo(username, newTodo.getDescribtion(), newTodo.getTargetDate(), newTodo.isDone());
        return "redirect:todo-list"; // Redirect to the list of todos
    }

    
    
    
    
    
    
    // Show the form to update an existing ToDo item
    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        ToDo existingTodo = todorepoistry.findById(id).get();
        model.addAttribute("todo", existingTodo);
        return "addtodo"; // Use the same view as for adding todos to keep the form consistent
    }

    // Handle the submission of the updated ToDo item form
    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String handleUpdateTodo(@ModelAttribute("todo") @Valid ToDo updatedTodo, BindingResult result) {
        if (result.hasErrors()) {
            return "addtodo"; // Return to the form view if there are validation errors
        }
        String username = userLogedInName();
        updatedTodo.setUserName(username);
        todorepoistry.saveAndFlush(updatedTodo);
        return "redirect:todo-list";
    }
}
