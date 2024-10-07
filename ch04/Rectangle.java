// 03 클래스 생성

package ch04;

public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int square() {
        return width * height;
    }

    public void show() {
        System.out.printf("(%d, %d)에서 크기가 %dx%d인 사각형\n", x, y, width, height);
    }

    public boolean contains(Rectangle a) {
        if (x < a.x && y < a.y)
            if (x + width > a.x + a.width && y + height > a.height)
                return true;
            return false;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(3, 3, 9, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(4, 4, 10, 10);

        r.show();
        System.out.println("s의 면적은 " + s.square());
        if (t.contains(r))
            System.out.println("t는 r을 포함합니다.");
        if (t.contains(s))
            System.out.println("t는 s를 포함합니다.");
    }
}
