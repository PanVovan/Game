package com.company;

public class Stats {
    static boolean isGame = true;
    static int progress;
    static int progressEnemy;
    static int dateDay = 0;
    static int dateMonth = 1;
    static int dateYear = 1;

    public Stats() {
    }

    static void ChangeDate() {
        ++dateDay;
        if ((dateMonth <= 9 && dateMonth % 2 == 1 || dateMonth >= 10 && dateMonth % 2 == 0) && dateDay == 32) {
            dateDay = 1;
            ++dateMonth;
        }

        if ((dateMonth <= 9 && dateMonth % 2 == 0 || dateMonth >= 10 && dateMonth % 2 == 1) && dateDay == 31 && dateMonth != 2) {
            dateDay = 1;
            ++dateMonth;
        }

        if ((dateYear % 4 == 0 && dateDay == 30 || dateYear % 4 != 0 && dateDay == 29) && dateMonth == 2) {
            dateDay = 1;
            ++dateMonth;
        }

        if (dateMonth == 12) {
            dateMonth = 1;
            ++dateYear;
        }

        if (Player.drunkenness >= 5) {
            Player.drunkenness -= 5;
        }

        if (Player.tired >= 5) {
            Player.tired -= 5;
        }

    }
}
