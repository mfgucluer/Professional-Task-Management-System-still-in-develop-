package com.taskmanagement.taskmanagement.Repository;

import com.taskmanagement.taskmanagement.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
