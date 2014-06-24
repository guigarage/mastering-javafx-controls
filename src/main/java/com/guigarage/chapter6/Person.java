package com.guigarage.chapter6;

public class Person {

    private String firstName;
    private String lastName;
    private String job;

    private boolean EmployeeOfTheMonth = true;

    public Person(String firstName, String lastName, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public boolean isEmployeeOfTheMonth() {
        return EmployeeOfTheMonth;
    }

    public void setEmployeeOfTheMonth(boolean employeeOfTheMonth) {
        EmployeeOfTheMonth = employeeOfTheMonth;
    }

    @Override
    public String toString() {
        return firstName + " "  + lastName + ": " + job + ": " + EmployeeOfTheMonth;
    }
}
