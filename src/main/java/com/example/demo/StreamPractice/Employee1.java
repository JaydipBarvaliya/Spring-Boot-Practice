package com.example.demo.StreamPractice;

public class Employee1 {


    private int empId;
    private String empName;
    private int depId;
    private String status = "active";
    private int salary;


    public Employee1(int empId, String empName, int depId, String status, int salary) {
        this.empId = empId;
        this.empName = empName;
        this.depId = depId;
        this.status = status;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PracticeEmployee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", depId=" + depId +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                '}';
    }
}
