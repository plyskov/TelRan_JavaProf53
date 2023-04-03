package lesson2.university;

public class University {

    public static void main(String[] args) {

        Student max = new Student("Max", 20, 2, "music");
        Staff alex = new Staff("Alex", 43, 50_000, "math");

        Student margareth = new Student("Margareth", 21, 3, "politics");

        // массив студентов и работников

        Person[] people = new Person[10];

        people[0] = max;
        people[1] = alex;
        people[2] = margareth;

        // добавьте маргарет в список
        // подсчитать в цикле возраст всех людей в универе

        int common_age = 0;

        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) {
                common_age += people[i].getAge();

                // ПОЛИМОРФИЗМ:
                // По ссылке на экземпляр базового класса вызывается
                // функция, переопределенная в производном.
                people[i].introduce();
            }
        }

        System.out.println("Common age: " + common_age);

        //people[1].getSalary(); // Нельзя, компилятор считает, что в массиве Person,  а не Staff

    }

}
