package com.projectTest.example.projectTest.entity;

import lombok.Data;

import javax.persistence.*;



@Entity
@Table(name="Health_Issues")
@Data
public class HealthIssues {

    @Id
    @Column(name="Health_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Health_Type")
    private String type;

    @Column(name = "Health_Name")
    private String name;

    @Column(name = "Health_Status")
    private Long status;



}
