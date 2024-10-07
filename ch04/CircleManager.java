// 05 객체 배열(1)

package ch04;

import java.util.Scanner;

class Circle {
    private double x;
    private double y;
    private int radius;

    public Circle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void show() {
        System.out.printf("가장 면적이 큰 원은 (%.1f, %.1f)%d", x, y, radius);
    }

    public double getArea() {
        return Math.PI * radius;
    }
}

public class CircleManager {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Circle one[] = new Circle[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("x, y, radius >>");

            double x = s.nextDouble();
            double y = s.nextDouble();
            int radius = s.nextInt();

            one[i] = new Circle(x, y, radius);
        }

        if (one[0].getArea() > one[1].getArea())
            one[0].show();
        else if (one[1].getArea() > one[2].getArea())
            one[1].show();
        else
            one[2].show();

        s.close();
    }
}
