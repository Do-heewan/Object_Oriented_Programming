// 01 클래스, 생성자, toSting(), equals()

package ch07;

class Circle {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public String toString() {
        return "Circle 중심 (" + x + "," + y + ")" + ", 반지름 : " + radius;
    }

    public boolean equals(Object obj) {
        Circle one = (Circle)obj;
        if (x == one.x && y == one.y)
            return true;
        else
            return false;
    }
}

public class week7_1 {
    public static void main(String[] args) {
        Circle a = new Circle(2, 10, 18);
        Circle b = new Circle(2,10,13);

        System.out.println("원 a >> " + a); // toString() 메소드 자동 호출
        System.out.println("원 a >> " + a.toString());
        System.out.println("원 b >> " + b);

        if(a.equals(b))
            System.out.println("같은 원입니다.");
        else
            System.out.println("서로 다른 원입니다.");
    }
}
