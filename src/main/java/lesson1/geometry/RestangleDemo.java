package lesson1.geometry;

public class RestangleDemo {

    public static void main(String[] args) {

        // Пробуем конструктор по 2 точкам. Определим прямоугольник со сторонами 3х2.
        Point point_nw = new Point(2, 8);
        Point point_sw = new Point(5, 6);
        Restangle restangle1 = new Restangle(point_nw, point_sw);

        System.out.println("Rectangle 1 area is: " + restangle1.area());

        // Пробуем конструктор по 4 координатам для 2 точек.
        // Определим тот же прямоугольник со сторонами 3х2.

        Restangle restangle2 = new Restangle(2, 8, 5, 6);

        System.out.println("Rectangle 2 area is: " + restangle2.area());

    }

}
