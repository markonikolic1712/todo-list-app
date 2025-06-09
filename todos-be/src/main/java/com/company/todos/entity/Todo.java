package com.company.todos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "todo_user_id", referencedColumnName = "user_id")
    private TodoUser todoUser;
}
