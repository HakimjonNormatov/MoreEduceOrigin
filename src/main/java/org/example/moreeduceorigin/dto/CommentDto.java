package org.example.moreeduceorigin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String name;
    private String email;
    private String comment;
    private String created_date = LocalDateTime.now().toString();
    private Integer like_id;
}
