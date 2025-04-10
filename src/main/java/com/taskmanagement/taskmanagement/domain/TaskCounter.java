package com.taskmanagement.taskmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "global_task_counter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "counter_value")
    private int counterValue = 0;
    
    // There will only be one record in this table
    @Column(name = "counter_name")
    private String counterName = "GLOBAL_COUNTER";
} 