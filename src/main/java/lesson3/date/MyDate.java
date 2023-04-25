package lesson3.date;

public class MyDate {

    private int year, month, day; // При  желании месяц преобразовать в перечисление

    // Добавить конструкторы, геттеры, сеттеры
    // Добавить функцию


    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void add(int days) {
        // увеличить дату на количество дней days
        // убедиться, что дата правильная. Пример: 27.02.2020 + 3 дня = 01.03.2020
        // учесть количество дней в месяцах и високосные годы
        // Попроверять разные варианты

        int daysLeft = days;

        int currentDay = day;
        int currentMonth = month;
        int currentYear = year;

        while(daysLeft > 0) {
            // Определим, сколько дней осталось до конца текущего месяца
            int daysLeftInCurrentMonth = daysInMonth(currentMonth, currentYear) - currentDay;

            // если оставшееся количество дней больше, чем daysLeft, увелисиваем дни в тек месяце
            if (daysLeftInCurrentMonth >= daysLeft) {
                currentDay += daysLeft;
                daysLeft = 0;
            } else {
                daysLeft -= (daysLeftInCurrentMonth + 1); // +1 - потому что при переходе в след месяц мы оказываемся в дне № 1, а не №0
                currentDay = 1;
                if (currentMonth == 12) {
                    currentMonth = 1;
                    currentYear++;
                } else {
                    currentMonth++;
                }
            }

        }
        year = currentYear;
        month = currentMonth;
        day= currentDay;
    }

    // Сколько дней в конкретном месяце конкретного года
    private int daysInMonth(int month, int year) {
        switch (month)
        {
            case 2: {
                if (isLeapYear(year))
                    return 29;
                else return 28;
            }
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            default:
                return 30;
        }
    }

    // Функция проверяет, является ли год високосным. Алгоритм описан в Википедии.
    private boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 00)
            return false;
        return (year % 4 == 0);
    }

    @Override
    public String toString() {
        return "year=" + year +
                ", month=" + month +
                ", day=" + day;
    }

    public static void main(String[] args) {
        MyDate d = new MyDate(2022, 4, 18);
        System.out.println(d);

        //d.add(30);
        d.add(365);
        System.out.println(d);

    }

}
