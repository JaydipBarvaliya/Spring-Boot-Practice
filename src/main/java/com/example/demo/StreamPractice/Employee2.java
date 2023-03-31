package com.example.demo.StreamPractice;

public class Employee2 {
    private int id;
    private String name;
    private String grade;
    private double salary;

    public Employee2() {
    }

    public Employee2(int id, String name, String grade, double salary) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", salary=" + salary +
                '}';
    }

















    public static Employee1 emp2To1Converter(Employee2 employee2) {
        return new Employee1(101, employee2.getName(), employee2.getId(), "active", employee2.getId());
    }














}

