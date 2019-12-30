package com.company;

public class EnemyParticipant extends Employee implements EmployeeSkills {
    EnemyParticipant(int salary, int income, boolean isHired, float coefficientIncome, float coefficientSalary, int skillServer) {
        super(salary, income, isHired, coefficientIncome, coefficientSalary, skillServer);
    }

    public void sleeplessNight() {
        int difference = (int)(Math.random() * 1000.0D);
        Resource.enemyMoney += difference;
    }

    public void makeDDOS() {
        if ((int)(Math.random() * 10.0D) > 5) {
            Resource.server -= (int)((double)this.skillDDoS * Math.random());
        } else {
            Resource.enemyMoney -= (int)(Math.random() * 1000.0D);
        }

    }

    public void increaseSkill() {
        if (Stats.dateMonth % 4 == 1) {
            this.coefficientIncome = (float)((double)this.coefficientIncome + Math.random());
            this.coefficientSalary = (float)((double)this.coefficientSalary + Math.random());
            this.skillDDoS += (int)(Math.random() * 10.0D);
            this.skillServer += (int)(Math.random() * 10.0D);
        }

    }
}