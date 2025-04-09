package com.taskmanagement.taskmanagement.repository;

import com.taskmanagement.taskmanagement.domain.TaskNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskNumberRepository extends JpaRepository<TaskNumber, Long> {

    Optional<TaskNumber> findByTaskNo(String taskNo);

}
