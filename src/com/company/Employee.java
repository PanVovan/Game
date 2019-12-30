package com.company;

public abstract class Employee {
    int salary;
    int income;
    int skillDDoS = 1;
    int skillServer;
    boolean isHired;
    float coefficientSalary;
    float coefficientIncome;

    Employee(int salary, int income, boolean isHired, float coefficientIncome, float coefficientSalary, int skillServer) {
        this.coefficientIncome = coefficientIncome;
        this.coefficientSalary = coefficientSalary;
        this.income = income;
        this.salary = salary;
        this.isHired = isHired;
        this.skillServer = skillServer;
    }
}
