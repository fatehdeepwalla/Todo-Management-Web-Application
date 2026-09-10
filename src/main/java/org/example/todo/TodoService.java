package org.example.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> Todos = new ArrayList<>();
    private static int toDoCount = 0;

    static {
        Todos.add(new Todo(++toDoCount, "in28minutes", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        Todos.add(new Todo(++toDoCount, "in28minutes", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        Todos.add(new Todo(++toDoCount, "in28minutes", "Learn Full Stack Development",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<Todo> predicate=todo ->todo.getUsername().equalsIgnoreCase(username);
        return Todos.stream().filter(predicate).toList();
    }
    public Todo findById(int id) {
        Predicate<Todo> predicate=todo ->todo.getId()==id;
        return Todos.stream().filter(predicate).findFirst().get();
    }

    public void addToDo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo= new Todo(++toDoCount, username, description, targetDate, done);
        Todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<Todo> predicate=todo ->todo.getId()==id;
        Todos.removeIf(predicate);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        Todos.add(todo);
    }
}
