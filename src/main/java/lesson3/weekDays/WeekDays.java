package lesson3.weekDays;

import java.util.Arrays;

public enum WeekDays {
    // Создать перечисление дней недели
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY; // После значений ставим точку с запятой, дальше пишем main и другие нужные метожы

    public static void main(String[] args) {
        System.out.println(MONDAY);
        System.out.println(SUNDAY.ordinal()); // порядковый номер в процессе объявления, начиная с 0
        System.out.println(
                Arrays.toString(
                        WeekDays.values()
                )
        );

        WeekDays day = WeekDays.FRIDAY;
        day = WeekDays.valueOf("WEDNESDAY");
    }

    public boolean isWorkDay() {
        // возвращать true с понедельника по пятницу
        return false;
    }

    public boolean isWeekEnd() {
        // возвращать true если суббота и воскресенье
        return true;
    }

}
