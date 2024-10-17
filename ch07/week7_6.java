// swing 프레임

package ch07;

import javax.swing.*;

public class week7_6 extends JFrame{
    public week7_6 (String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new week7_6("Let's Study Java");
    }
}
