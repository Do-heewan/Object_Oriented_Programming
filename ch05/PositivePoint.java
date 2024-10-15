// 06 서브 클래스의 생성자와 메소드 생성, super() 활용

package ch05;

public class PositivePoint extends Point {
    public PositivePoint() {
        super();
    }

    public PositivePoint(int x, int y) {
        if (x > 0 & y > 0) {
            this.x = x;
            this.y = y;
        }
        else {
            this.x = 0;
            this.y = 0;
        }
    }

    public void move(int x, int y) {
        if (x > 0 & y > 0) {
            this.x = x;
            this.y = y;
        }
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ")의 점";
    }

    public static void main(String[] args) {
        PositivePoint p = new PositivePoint();
        p.move(11, 11);
        System.out.println(p.toString() + "입니다.");

        p.move(-5, 5);
        System.out.println(p.toString() + "입니다.");

        PositivePoint p2 = new PositivePoint(-10, -10);
        System.out.println(p2.toString() + "입니다.");
    }
}
