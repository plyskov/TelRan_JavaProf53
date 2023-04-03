package lesson2.crossword;

public class A {
    public void hello() {
        System.out.println("Hello from A");
    }

    private void world() {
        System.out.println("World");
    }
    protected void hi() {
        System.out.println("Hi");
    }

    // final - не может быть переопределена в дочерних классах
    final public void secure(){
        System.out.println("Secure A");
    }

}
