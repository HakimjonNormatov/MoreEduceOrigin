package org.example.moreeduceorigin.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.moreeduceorigin.model.LEVEL;
import org.example.moreeduceorigin.model.Students;
import org.example.moreeduceorigin.model.Teacher;
import org.example.moreeduceorigin.model.Test;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto {
    private String name;
    private String description;
    private String duration;
    private Teacher teacher_id;
    private Students all_student;
    private LEVEL level_id;
    private Test test_id;
    private String count;
}
