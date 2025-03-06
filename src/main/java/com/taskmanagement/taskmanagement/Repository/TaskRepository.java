package com.taskmanagement.taskmanagement.Repository;

import com.taskmanagement.taskmanagement.Domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
