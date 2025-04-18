package org.example.moreeduceorigin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.moreeduceorigin.model.temp.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @Column(nullable = false , unique = true)
    private String Email;
    @Column(nullable = false , unique = true)
    private String Username;
    @Column(nullable = false)
    private Long age;
    @Column(nullable = false)
    private String phonenumber;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String repassword;
    @ManyToOne
    private Address address_id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreatedDate
    private LocalDateTime localDateTime=LocalDateTime.now();

}
