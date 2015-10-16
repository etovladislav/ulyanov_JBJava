package ru.kpfu.itis.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stdScores")
    @SequenceGenerator(sequenceName = "students_id_seq", name = "stdScores")
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "surname", nullable = false)
    private String surName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "studgroup", nullable = false)
    private String studGroup;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudGroup() {
        return studGroup;
    }

    public void setStudGroup(String studGroup) {
        this.studGroup = studGroup;
    }
}
