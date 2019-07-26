package lesson1.enums;

public class DayofWeekMain {

    public static void main(String[] args) {
        getWorkingHours(DayOfWeek.FRIDAY);

    }

    public static void getWorkingHours(DayOfWeek dayOfWeek) {
        int hourstoRest = 0;
        int day = dayOfWeek.getNumberOfDay();

        if (day < 6) {
            while (day < 6) {
                hourstoRest += dayOfWeek.getWorkhours();
                day++;
            }
            System.out.println("До выходных осталось " + hourstoRest + " часов!");
        } else System.out.println("Сегодня выходной!");
    }
}