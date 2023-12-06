package com.example.nikki.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Form {
    private Integer id;
    private String data;
    private String title;
    private String text;
}
