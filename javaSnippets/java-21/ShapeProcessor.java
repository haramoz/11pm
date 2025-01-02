// Define a sealed class hierarchy for different shape types
sealed interface Shape permits Circle, Rectangle, Triangle {
    double area();
}

final class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

final class Rectangle implements Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }
}

final class Triangle implements Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }
}

public class ShapeProcessor {
    public static void printShapeDetails(Shape shape) {
        switch (shape) {
            case Circle c -> System.out.println("Circle with area: " + c.area());
            case Rectangle r -> System.out.println("Rectangle with area: " + r.area());
            case Triangle t -> System.out.println("Triangle with area: " + t.area());
            default -> System.out.println("Unknown shape");
        }
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 5);
        Shape triangle = new Triangle(3, 4);
        printShapeDetails(circle);
        printShapeDetails(rectangle);
        printShapeDetails(triangle);
    }
}
