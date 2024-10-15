// 01 상속받은 클래스 생성(기본)

package ch05;

class TV {
    private int size;
    
    public TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

public class ColorTV extends TV{
    int color;

    public ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }

    public void printProperty() {
        System.out.printf("TV 속성 : %d 인치 / %d 해상도", getSize(), color);
    }

    public static void main(String[] args) {
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();
    }
}
