package com.kennycode.employee;

import java.util.Date;

public class Employee {
    private long id;
    private String firstname;
    private String lastname;
    private String title;
    private String department;
    private Date hireDate;
    private boolean isOnBoard;
    private String note;

    public Employee(long id, String firstname, String lastname, String title, String department, Date hireDate, boolean isOnBoard, String note) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.department = department;
        this.hireDate = hireDate;
        this.isOnBoard = isOnBoard;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isOnBoard() {
        return isOnBoard;
    }

    public void setOnBoard(boolean onBoard) {
        isOnBoard = onBoard;
    }
}
