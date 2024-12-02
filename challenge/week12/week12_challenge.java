package challenge.week12;

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("반지름이 " + radius + "인 원입니다.");
    }

    public double getArea() {
        return PI * radius * radius;
    }
}

class Oval implements Shape {
    private int width, height;

    public Oval(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println(width + "x" + height + "에 내접하는 타원입니다.");
    }

    public double getArea() {
        return (width/2) * (height/2) * PI;
    }
}

class Rect implements Shape {
    private int width, height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println(width + "x" + height + "크기의 사각형 입니다.");
    }

    public double getArea() {
        return width * height;
    }
}

public class Week12_challenge {
    public static void main(String[] args) {
        Shape list[] = new Shape[3];
        list[0] = new Circle(5);
        list[1] = new Oval(30, 50);
        list[2] = new Rect(20, 40);

        for (int i = 0; i < list.length; i++)
            list[i].redraw();
        for (int j = 0; j < list.length; j++)
            System.out.println("면적은 " + list[j].getArea());
    }
}
