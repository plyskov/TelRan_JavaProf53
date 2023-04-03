package lesson2.crossword;

public class TestABC {

    public static void main(String[] args) {
        C c = new C();
        c.hello(); // публичный метод из базового класса наследуется и работает,
        //            даже если не определен в самом дочернем классе

        B b = new B();
        // b.world(); // Приватные методы и поля родительского класса не наследуются и не млогут быть вызваны

        c.hi(); // protected можно позвать

        c.secure();


    }

}
