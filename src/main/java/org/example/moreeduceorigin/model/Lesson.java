package org.example.moreeduceorigin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String duration;
    @ManyToOne
    private Teacher teacher_id;
    @ManyToOne
    private Students all_student;
    @Enumerated
    //@ManyToMany
    private LEVEL level_id;
    @ManyToOne
    private Test test_id;
    @Column(nullable = false , unique = true)
    private String count;
}
