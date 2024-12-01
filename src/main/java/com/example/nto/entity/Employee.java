package com.example.nto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Employee")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "name")
    private String name;
    @Column(name = "photo")
    private String photo;
    @Column(name = "position")
    private String position;
    @Column(name = "LastVisit")
    private LocalDateTime lastVisit;

    /*public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }*/
}
