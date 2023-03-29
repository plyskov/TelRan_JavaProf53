package lesson1.japanese;

public class JapaneseEmployee {

    public static void main(String[] args) {

        // Посчитать ЗП:
        // Mitsuo Baso     120_000    4
        // Akura Kurosava   100_000   12

        JapaneseEmployee mitsuoBaso = new JapaneseEmployee("Mitsuo", "Baso", 120_000, 04);
        JapaneseEmployee akuraKurosava = new JapaneseEmployee("Akura", "Kurosava", 100_000, 12);

        System.out.println("Mitso salary: " + mitsuoBaso.calculateSalary());
        System.out.println("Akuro salary: " + akuraKurosava.calculateSalary());

        mitsuoBaso.hello();
        akuraKurosava.hello();

    }

    private String firstName;
    private String lastName;
    private double baseSalary;
    private int years;

    public static int delta = 10_000;

    // Калькулировать зарплату по выслуге лет
    // Базовая зарплата + (количество лет * дельту за выслугк)

    public int calculateSalary(){
        int salary = (int) baseSalary + (years * JapaneseEmployee.delta);
        //System.out.println("Salary of " + lastName + " is: " + salary);
        return salary;
    }

    public void hello(){
        // Работает > 10 лет - имя+фамилия
        // иначе - имя
        if (years < 10) {
            System.out.println("Привет, " + firstName + "!");
        } else {
            System.out.println("Добрый день, " + firstName + " " + lastName + "!");
        }
    }

    // Создать конструктор со всеми параметрами
    // Создать геттеры и сеттеры

    public JapaneseEmployee(String firstName, String lastName, double baseSalary, int years) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
        this.years = years;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

}
