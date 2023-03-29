package lesson1.geometry;

public class Restangle {

    // se, nw - юго-восточная точка и северо-западная
    Point nw;
    Point se;

    // Добавьте конструктор, геттеры и сеттеры
    // Посчитать площадь

    public Restangle(Point nw, Point se) {
        this.nw = nw;
        this.se = se;
    }

    public Restangle(int x1, int y1, int x2, int y2) {
        nw = new Point(x1, y1);
        se = new Point(x2, y2);
    }

    public double area() {
        return abs(nw.getX(), se.getX()) * abs(nw.getY(), se.getY());
    }

    private double abs(double a, double b) {
        double difference = a - b;
        if (difference < 0){
            return -difference;
        } else {
            return difference;
        }
    }

}
