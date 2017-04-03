package com.theironyard.novauc.repository;

import com.theironyard.novauc.domain.Todo;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Todo entity.
 */
@SuppressWarnings("unused")
public interface TodoRepository extends JpaRepository<Todo,Long> {

}
