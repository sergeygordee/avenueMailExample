package com.example.avenueMailExample.entity;

import lombok.Data;

@Data
public class EmailForm {
    private String email;
    private String text;
    private String subject;
}
