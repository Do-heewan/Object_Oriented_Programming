// 08 멤버 접근 지정자와 메소드(2)

package ch05;

class MyTV2 {
    boolean isPowerOn;
    int channel;
    int volume;
    int prevChannel;
    int MAX_VOLUME = 100;
    int MIN_VOLUME = 0;
    int MAX_CHANNEL = 100;
    int MIN_CHANNEL = 1;

    void setChannel(int channel) {
        if (channel >= 1 & channel <= 100) {
            if (this.channel != channel) {
                prevChannel = this.channel;
                this.channel = channel;
            }
        }
    }

    int getChannel() {
        return channel;
    }

    public void gotoPrevChannel() {
        setChannel(prevChannel);
    }
}

public class week5_8 {
    public static void main(String[] args) {
        MyTV2 t = new MyTV2();

        t.setChannel(10);
        System.out.println("채널 : " + t.getChannel());
        t.setChannel(20);
        System.out.println("채널 : " + t.getChannel());

        t.gotoPrevChannel();
        System.out.println("채널 : " + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("채널 : " + t.getChannel());
    }
}
