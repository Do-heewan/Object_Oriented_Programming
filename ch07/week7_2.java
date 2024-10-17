// 02 클래스, package, import

package ch07;

class Shape {
    public void draw() {
        System.out.println("Shape");
    }
}

class Rectangle extends Shape{
    public void draw() {
        System.out.println("Circle");
    }
}

public class week7_2 {
    public static void main(String[] args) {
        Shape shape = new Rectangle();
        shape.draw();
    }
}
