package com.java.studentmanagerfx;

import java.time.LocalDate;

public class Student {


    //region Attributes
    private int id;
    private String name;
    private String gender;
    private String email;
    private LocalDate birthDate;
    private String photo;
    private double mark;
    private String comments;

    //endregion

    //region Getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }
    //endregion

    //region Setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }
    //endregion

    //region Constructors

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Student(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    //endregion

    //region Methods

    @Override
    public String toString() {
        return "Name:" + name ;
    }
    //endregion
}