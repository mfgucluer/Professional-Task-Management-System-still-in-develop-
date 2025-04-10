package com.taskmanagement.taskmanagement.repository;

import com.taskmanagement.taskmanagement.domain.TaskCounter;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCounterRepository extends JpaRepository<TaskCounter, Long> {
    
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT tc FROM TaskCounter tc WHERE tc.counterName = 'GLOBAL_COUNTER'")
    TaskCounter findGlobalCounterForUpdate();
    
    TaskCounter findByCounterName(String counterName);
} 