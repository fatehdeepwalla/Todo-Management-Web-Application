package org.example.todo_final;

import jakarta.validation.Valid;
import org.example.todo_temp.TodoService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class TodoControllerJPA {
    private TodoRepository todoRepository;


    public TodoControllerJPA(TodoService todoService, TodoRepository todoRepository)
    {
        this.todoRepository = todoRepository;
    }

    @GetMapping("list-todo")
    public String list(ModelMap model) {
        String username=getLoggedInUsername();
        model.put("username", username);
        model.put("listToDo", todoRepository.findByUsername(username));
        return "listTodo";
    }

    @GetMapping("add-todo")
    public String addGet(ModelMap model) {
        model.put("todo", new Todo());
        return "addTodo";
    }

    @PostMapping("add-todo")
    public String addPost(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "addTodo";
        }
        String username=getLoggedInUsername();
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:/list-todo";
    }

    @GetMapping("delete-todo")
    public String delete(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:/list-todo";
    }

    @GetMapping("update-todo")
    public String updateGet(@RequestParam int id, ModelMap model) {
        Todo todo= todoRepository.findById(id).get();
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
        todoRepository.save(todo);
        return "redirect:/list-todo";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
