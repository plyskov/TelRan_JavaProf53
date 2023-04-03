package lesson2.shape;

// abstract - класс не вляется конкретным, создать его экземпляр нельзя
public abstract class Figure {

    // abstract - не содержит реализации. Это шаблон, который должен быть определен в дочерних классах.

    abstract double area();
    abstract double perimeter();

    void hello() {

    }

}
