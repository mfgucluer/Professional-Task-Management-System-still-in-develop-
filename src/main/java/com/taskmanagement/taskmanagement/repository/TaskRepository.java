package com.taskmanagement.taskmanagement.repository;

import com.taskmanagement.taskmanagement.domain.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser_id(Long userId);

    @Transactional
    void deleteAllByUserId(Long userId);

}
