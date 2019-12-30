package com.company;

import java.util.Scanner;

public class Main {
    public static int answer;

    public Main() {
    }

    public static void menuParticipant(YourParticipant yourParticipant) {
        if (yourParticipant.isHired) {
            Scanner scan = new Scanner(System.in);

            while(true) {
                answer = scan.nextInt();
                if (answer < 4 && answer > 0) {
                    yourParticipant.action(answer);
                    break;
                }

                System.out.println("Повторите ввод");
            }
        } else {
            yourParticipant.isHired = true;
            System.out.println("Вы наняли помощника");
        }

    }

    public static void menuShop(Shop shop) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            answer = scan.nextInt();
            if (answer < 3 && answer > 0) {
                int count = scan.nextInt();
                shop.action(answer, count);
                return;
            }

            System.out.println("Повторите ввод");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        YourParticipant participant = new YourParticipant(500, 600, false, 1.1F, 1.1F, 1);
        EnemyParticipant enemyParticipant = new EnemyParticipant(500, 600, false, 1.1F, 1.1F, 1);
        Player player = new Player(scanner.next());
        Resource.money = 1000;
        Resource.beer = 0;
        Resource.server = 1;
        Stats.progress = 0;
        boolean isGaming = true;
        Resource.enemyMoney = 1000;
        Resource.enemyServer = 1;
        Stats.progressEnemy = 0;
        System.out.println("Проект");
        System.out.println("Вы - фрилансер, перебивающийся случайными заработками. И вот вы взялись за проект некоторой компании, который,\n возможно даст вам возможность повысить рейтинг (или наконец-то найти нормальную работу) \nНо есть одно небольшое но, взялись за это не только вы, поэтому вам нужно закончить этоо раньше вашего конкурента\n");

        while(isGaming) {
            Stats.ChangeDate();
            System.out.println("Дата: " + Stats.dateDay + "." + Stats.dateMonth + "." + Stats.dateYear);
            System.out.println("И так, с чего начнем день?\n1) Поработать\n2) Культурно отдохнуть\n3) Помощник \n4) Сходить в магазин \n5) Заняться проектом \n");
            player.setEfficiency(Player.tired, Player.drunkenness);

            while(true) {
                answer = scanner.nextInt();
                if (answer < 6 && answer > 0) {
                    if (answer == 1) {
                        Resource.money += 5 * player.efficiency;
                        Player.tired += 10;
                    } else if (answer == 2) {
                        player.drunk();
                    } else if (answer == 3) {
                        System.out.println("Что?\n1) DDoS \n2) Работать всю ночь\n3) Повысить квалификацию\n");
                        menuParticipant(participant);
                    } else if (answer == 4) {
                        System.out.println("Вы зашли в магазин. Что вам?\n1) Сервер 500 руб\n2) Пиво 50 руб\n");
                        menuShop(shop);
                    } else {
                        ++Stats.progress;
                    }

                    if (participant.isHired) {
                        Resource.money = (int)((float)Resource.money + (float)participant.income * participant.coefficientIncome);
                    }

                    Stats.progress += Resource.server * participant.skillServer;
                    if (enemyParticipant.isHired) {
                        int a = (int)(Math.random() * 10.0D);
                        if (a == 1 && Resource.server > 10) {
                            enemyParticipant.makeDDOS();
                        } else if (a == 2) {
                            enemyParticipant.increaseSkill();
                        } else if (a == 0) {
                            enemyParticipant.sleeplessNight();
                        }
                    } else if (Math.random() * 20.0D > 10.0D) {
                        enemyParticipant.isHired = true;
                    }

                    Stats.progressEnemy += Resource.enemyServer * enemyParticipant.skillServer;
                    System.out.println("Progress " + Stats.progress + " Progress enemy " + Stats.progressEnemy + " Money " + Resource.money + " Server " + Resource.server + Resource.enemyServer + "\n\n\n");
                    break;
                }

                System.out.println("Повторите ввод");

            }

            if(Stats.progress >999){
                System.out.println("Вы выиграли");
                isGaming = false;
            }
            if(Stats.progressEnemy >999){
                System.out.println("Вы проиграли");
                isGaming = false;
            }

        }

    }
}
