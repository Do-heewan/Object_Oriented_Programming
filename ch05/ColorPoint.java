// 05 서브 클래스의 생성자와 메소드 생성

package ch05;

class Point {
    int x = 0;
    int y = 0;
    public Point() {
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y =y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ColorPoint extends Point {
    String color;

    public ColorPoint() {
        color = "BLACK";
        super.getX();
        super.getY();
    }

    public ColorPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return color + "색의 (" + getX() + ", " + getY() + ")의 점";
    }

    public static void main(String[] args) {
        ColorPoint zeroPoint = new ColorPoint(); // Black 색에 (0, 0) 위치의 점
        System.out.println(zeroPoint.toString() + "입니다.");

        ColorPoint cp = new ColorPoint(10, 10);
        cp.setXY(10, 11);
        cp.setColor("RED");
        System.out.println(cp.toString() + "입니다.");
    }
}