// 07 멤버 접근 지정자와 메소드(1)

package ch05;

class MyTV {
    boolean isPowerOn;
    private int channel;
    private int volume;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public void setChannel(int channel) {
        if (channel >= MIN_CHANNEL & channel <= MAX_CHANNEL) {
            this.channel = channel;
        }
    }

    public int getChannel() {
        return channel;
    }

    public void setVolume(int volume) {
        if (volume >= MIN_VOLUME & volume <= MAX_VOLUME) {
            this.volume = volume;
        }
        
    }

    public int getVolume() {
        return volume;
    }
}

public class week5_7 {
    public static void main(String[] args) {
        MyTV t = new MyTV();
        t.setChannel(10);
        System.out.println("채널 : " + t.getChannel());
        t.setVolume(20);
        System.out.println("음량 : " + t.getVolume());
    }
}
