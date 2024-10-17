// 08 GridLayout, random() 메소드

package ch07;

import java.awt.*;
import javax.swing.*;
import java.lang.Math;

public class week7_8 extends JFrame{
    public week7_8() {
        setTitle("3x3 Color Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int r, g, b;

        GridLayout grid = new GridLayout(3, 3);

        Container c = getContentPane();
        c.setLayout(grid);
        
        JLabel jlabel[] = new JLabel[9];
        for (int i = 0; i < jlabel.length; i++) {
            r = (int)(Math.random() * 255);
            g = (int)(Math.random() * 255);
            b = (int)(Math.random() * 255);

            jlabel[i] = new JLabel(Integer.toString(i));
            jlabel[i].setOpaque(true);
            jlabel[i].setBackground(new Color(r, g, b));
            c.add(jlabel[i]);
        }

        setSize(400,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new week7_8();
    }
}
