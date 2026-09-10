package org.example.todo_final;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT t FROM Todo t WHERE t.username = :username")
    public List<Todo> findByUsername(String username);
}
