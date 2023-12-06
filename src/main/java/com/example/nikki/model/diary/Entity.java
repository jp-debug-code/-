package com.example.nikki.model.diary;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity
@Table(name="diary")
public class Entity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
    @Column(nullable = false,name="date")
    @NotNull
private LocalDate date;
    @NotEmpty
    @Size(max = 40)
    @Column(nullable = false,name="title")
private String title;
    @Size(max = 50)
    @Column(name = "use_tech")
    private  String use_tech;
    @Size(max = 1000)
    @NotBlank
    @Column(nullable = false,name = "text")
private String text;


}
