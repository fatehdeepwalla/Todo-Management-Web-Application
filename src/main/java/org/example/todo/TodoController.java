package org.example.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

//@Controller
@SessionAttributes("username")
public class TodoController {
    private TodoService toDoService;

    public TodoController(TodoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("list-todo")
    public String list(ModelMap model) {
        String username=getLoggedInUsername();
        model.put("listToDo", toDoService.findByUsername(username));
        return "listTodo";
    }

    @GetMapping("add-todo")
    public String addGet(ModelMap model) {
        model.put("todo", new Todo(1,null,"Default",null,false));
        return "addTodo";
    }

    @PostMapping("add-todo")
    public String addPost(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "addTodo";
        }
        String username=getLoggedInUsername();
        toDoService.addToDo(username,todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:/list-todo";
    }

    @GetMapping("delete-todo")
    public String delete(@RequestParam int id) {
        toDoService.deleteById(id);
        return "redirect:/list-todo";
    }

    @GetMapping("update-todo")
    public String updateGet(@RequestParam int id, ModelMap model) {
        Todo todo= toDoService.findById(id);
        model.put("todo",todo);
        return "addTodo";
    }

    @PostMapping("update-todo")
    public String updatePost(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "addTodo";
        }
        String username=getLoggedInUsername();
        todo.setUsername(username);
        toDoService.updateTodo(todo);
        return "redirect:/list-todo";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
