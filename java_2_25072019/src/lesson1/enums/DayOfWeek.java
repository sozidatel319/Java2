package lesson1.enums;

public enum DayOfWeek {

    MONDAY(8), TUESDAY(8), WEDNESDAY(8),
    THURSDAY(8), FRIDAY(8), SATURDAY(0), SUNDAY(0);

    private int workhours;

    DayOfWeek(int workhours) {
        if (workhours >= 0) this.workhours = workhours;
    }

    public int getWorkhours() {
        return workhours;
    }
}
