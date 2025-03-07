package com.taskmanagement.taskmanagement.Repository;

import com.taskmanagement.taskmanagement.Domain.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser_id(Long userİd);

    @Transactional
    void deleteAllByUserId(Long userId);

}
