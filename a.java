class Shape {
    public void draw() {
        System.out.println("Рисуем фигуру");
    }
}

class Circle extends Shape {
    @Override
    public void draw() { // переопределение метода базового класса
        System.out.println("Рисуем круг");
    }

    // Перегрузка в подклассе
    public void draw(String color) {
        System.out.println("Рисуем круг цветом: " + color);
    }
}

public class a {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.draw();
        Circle circle = new Circle();
        circle.draw();
        circle.draw("серо-буро-малиновый");

    }
}
