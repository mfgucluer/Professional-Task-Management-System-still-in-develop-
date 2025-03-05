package com.taskmanagement.taskmanagement.Repository;

import com.taskmanagement.taskmanagement.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
