package HomeworkOne;


class Shape {
    public void display() {
        System.out.println("Це фігура");
    }
}

class Circle extends Shape {
    @Override
    public void display() {
        System.out.println("Це коло");
    }

}

class Square extends Shape {
    @Override
    public void display() {
        System.out.println("Це квадрат");
    }
}

class Triangle extends Shape {
    @Override
    public void display() {
        System.out.println("Це трикутник");
    }
}

class Rectangle extends Shape {
    @Override
    public void display() {
        System.out.println("Це прямокутник");
    }
}

class Pentagon extends Shape {
    @Override
    public void display() {
        System.out.println("Це п'ятикутник");
    }
}
class ShapePrinter {
    public void printShapeName(Shape shape) {
        shape.display();
    }
}
public class ShapeTest {
    public static void main(String[] args) {

        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        Pentagon pentagon = new Pentagon();

        ShapePrinter shapePrinter = new ShapePrinter();

        shapePrinter.printShapeName(circle);
        shapePrinter.printShapeName(square);
        shapePrinter.printShapeName(triangle);
        shapePrinter.printShapeName(rectangle);
        shapePrinter.printShapeName(pentagon);
    }
}
