/**
 * ================================================================
 *  ShapesRedundancy  —  INHERITANCE DEMO: AVOIDING REDUNDANCY
 * ================================================================
 *  WITHOUT inheritance, every shape class would repeat:
 *    - color, filled  fields
 *    - getColor(), isFilled()  methods
 *    - toString()  method
 *
 *  WITH inheritance, those common features live ONCE in Shape.
 *  Each subclass only defines what is UNIQUE to it (area, perimeter).
 *
 *  Compile:  javac ShapesRedundancy.java
 *  Run:      java  ShapesRedundancy
 * ================================================================
 */

// ================================================================
//  PARENT CLASS — holds everything COMMON to all shapes
// ================================================================
abstract class Shape {
    protected String  color;
    protected boolean filled;

    public Shape(String color, boolean filled) {
        this.color  = color;
        this.filled = filled;
    }

    public String  getColor()  { return color;  }
    public boolean isFilled()  { return filled; }

    // Every shape MUST provide its own area and perimeter
    public abstract double area();
    public abstract double perimeter();

    @Override
    public String toString() {
        return String.format(
            "%-12s | color=%-8s | filled=%-5b | area=%8.2f | perimeter=%8.2f",
            getClass().getSimpleName(), color, filled, area(), perimeter()
        );
    }
}

// ================================================================
//  SUBCLASSES — each defines ONLY what is unique to it
// ================================================================

class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    @Override public double area()      { return Math.PI * radius * radius; }
    @Override public double perimeter() { return 2 * Math.PI * radius;      }
}

class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;  this.height = height;
    }

    @Override public double area()      { return width * height;           }
    @Override public double perimeter() { return 2 * (width + height);     }
}

class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c, String color, boolean filled) {
        super(color, filled);
        this.a = a;  this.b = b;  this.c = c;
    }

    @Override public double area() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override public double perimeter() { return a + b + c; }
}

// ================================================================
//  MAIN — demonstrate all shapes through the parent type
// ================================================================
public class ShapesRedundancy {
    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle   (5.0,              "Red",   true ),
            new Rectangle(4.0, 6.0,         "Blue",  false),
            new Triangle (3.0, 4.0, 5.0,    "Green", true )
        };

        System.out.println("Shape        | Color    | Filled | Area     | Perimeter");
        System.out.println("=".repeat(70));
        for (Shape s : shapes) {
            System.out.println(s);
        }
    }
}
