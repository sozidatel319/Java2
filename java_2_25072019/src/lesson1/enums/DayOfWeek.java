package lesson1.enums;

public enum DayOfWeek {

    MONDAY(8,1), TUESDAY(8,2), WEDNESDAY(8,3),
    THURSDAY(8,4), FRIDAY(8,5), SATURDAY(0,6), SUNDAY(0,7);

    private int workhours;
    private int numberOfDay;

    DayOfWeek(int workhours, int numberOfDay) {
        if (workhours >= 0) this.workhours = workhours;
        if (numberOfDay > 0 && numberOfDay < 8) this.numberOfDay = numberOfDay;
    }

    public int getWorkhours() {
        return workhours;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }
}
