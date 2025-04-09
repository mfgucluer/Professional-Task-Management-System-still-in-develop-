package com.taskmanagement.taskmanagement.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_number")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "task_no", nullable = false)
    private String taskNo;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;
}