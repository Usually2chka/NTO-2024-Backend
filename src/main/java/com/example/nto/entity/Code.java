package com.example.nto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "CODE")
@NoArgsConstructor
@AllArgsConstructor
public class Code {
    @Id
    //@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Value")
    private long value;
}
