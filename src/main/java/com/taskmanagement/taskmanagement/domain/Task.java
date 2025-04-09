package com.taskmanagement.taskmanagement.domain;


import com.taskmanagement.taskmanagement.generator.TaskNoGenerator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title alanı boş bırakılamaz!")
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean completed;


    @OneToOne(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    private TaskNumber taskNumber;

}
