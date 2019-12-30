package com.company;

public class Shop {
    public Shop() {
    }

    void action(int ans, int count) {
        if (ans == 1) {
            if (Resource.money >= 500 * count) {
                Resource.server += count;
                Resource.money -= 500 * count;
                System.out.println("Покупка совершена");
                Resource.rating += count * 2;
            } else {
                System.out.println("Недостаточно средств");
            }
        } else if (ans == 2) {
            if (Resource.money >= 50 * count) {
                Resource.beer += count;
                Resource.money -= 50 * count;
                System.out.println("Покупка совершена");
            } else {
                System.out.println("Недостаточно средств");
            }
        } else {
            System.out.println("Только время потерял");
        }

    }
}