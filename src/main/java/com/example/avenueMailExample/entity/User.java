package com.example.avenueMailExample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userPass")
    private String userPass;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "userCountry")
    private String userCountry;

}
