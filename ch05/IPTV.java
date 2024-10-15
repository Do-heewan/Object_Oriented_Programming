// 02 서브 클래스 생성

package ch05;

public class IPTV extends ColorTV{
    private String IP;

    public IPTV(int size, int color, String IP) {
        super(size, color);
        this.IP = IP;
    }
    
    public void printProperty() {
        System.out.printf("나의 IPTV는 %s 주소의 TV 속성 : %d 인치 / %d 해상도", IP, getSize(), color);
    }

    public static void main(String[] args) {
        IPTV iptv = new IPTV(32, 2048, "192.1.1.2");
        iptv.printProperty();
    }
}
