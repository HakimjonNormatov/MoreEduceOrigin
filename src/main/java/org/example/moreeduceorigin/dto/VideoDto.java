package org.example.moreeduceorigin.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {
    private String name;
    private String duration;
    private String size;
    private String path;
    private LocalDateTime created_date = LocalDateTime.now();
}
