// 02 생성자

package ch04;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("x : " + x + ", y : " + y);
    }

    public static void main(String[] args) {
        Point p1 = new Point(25, 50);
        Point p2 = new Point();

        p1.print();
        p2.print();

        p2.move(30, 40);
        p2.print();
    }
}
