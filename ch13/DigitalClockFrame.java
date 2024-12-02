// 06 스레드와 Calender 응용

package ch13;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class DigitalClockFrame extends JFrame{
    public DigitalClockFrame() {
        setTitle("디지털 시계");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.add(new MyLabel());
        setSize(300, 100);
        setVisible(true);
    }

    class MyLabel extends JLabel implements Runnable {
        private Thread timeThread = null;
        public MyLabel() {
            setText(makeClockText());
            setFont(new Font("Gothic", Font.ITALIC, 55));
            setHorizontalAlignment(JLabel.CENTER);
            timeThread = new Thread(MyLabel.this);
            timeThread.start();
        }

        public String makeClockText() {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            int second = c.get(Calendar.SECOND);

            String clockText = Integer.toString(hour).concat(":");
            clockText = clockText.concat(Integer.toString(minute));
            clockText = clockText.concat(":");
            clockText = clockText.concat(Integer.toString(second));

            return clockText;
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { return; }
                setText(makeClockText());
            }
        }

        public static void main(String[] args) {
            new DigitalClockFrame();
        }
    }
}
