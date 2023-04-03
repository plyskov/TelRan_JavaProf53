package lesson2.shape;

public class FigureTester {

    public static void main(String[] args) {
        Figure[] figures = new Figure[1000]; // массив всех возможных фигур

        figures[0] = new Circle(15);

        figures[0].area(); // Вызываем переопределенный абстрактный метод абстрактного класса

        // Figure а = new Figure(); // Экземпляр абстрактного класса создать нельзя

    }

}
