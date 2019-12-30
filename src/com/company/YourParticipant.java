package com.company;

public class YourParticipant extends Employee implements EmployeeSkills {
    YourParticipant(int salary, int income, boolean isHired, float coefficientIncome, float coefficientSalary, int skillServer) {
        super(salary, income, isHired, coefficientIncome, coefficientSalary, skillServer);
    }

    public void sleeplessNight() {
        if (Resource.rating > 10) {
            System.out.println("-Вам придется поработать в ночную смену\n-Ладно\n\n");
            int difference = (int)(Math.random() * 1000.0D);
            Resource.money += difference;
            System.out.println("Вы заработали " + difference + " рублей");
        } else {
            System.out.println("-Вам придется поработать в ночную смену\n-НЕТ!\n\n");
        }

    }

    public void makeDDOS() {
        if ((int)(Math.random() * 5.0D * (double)this.skillDDoS) > 5) {
            Resource.enemyServer -= (int)((double)this.skillDDoS * Math.random());
            ++this.skillDDoS;
            System.out.println("Удачно");
        } else {
            Resource.money -= (int)(Math.random() * 1000.0D);
            System.out.println("Неудачно");
        }

    }

    public void increaseSkill() {
        if (Stats.dateMonth % 3 == 1) {
            this.coefficientIncome = (float)((double)this.coefficientIncome + Math.random());
            this.coefficientSalary = (float)((double)this.coefficientSalary + Math.random());
            this.skillDDoS += (int)(Math.random() * 10.0D);
            this.skillServer += (int)(Math.random() * 10.0D);
        } else {
            System.out.println("В данный момент курсы недоступны");
        }

    }

    void action(int a) {
        if (a == 1) {
            this.makeDDOS();
        }

        if (a == 2) {
            this.sleeplessNight();
        }

        if (a == 3) {
            this.increaseSkill();
        }

    }
}
