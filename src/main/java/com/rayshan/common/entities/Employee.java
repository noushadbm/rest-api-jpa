package com.rayshan.common.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="email_id", nullable = false)
    private String emailId;

    @Column(name="hid")
    private Long healthId;

    public Employee() {}

    public Employee(String firstName, String lastName, String email, Long hid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = email;
        this.healthId = hid;
    }
}
