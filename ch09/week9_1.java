// 01 item 리스너, 컴포넌트의 메소드 활용

package ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class week9_1 extends JFrame {
    private JButton btn = new JButton("test button");
    public week9_1() {
        super("CheckBox Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox a = new JCheckBox("버튼 비활성화");
        JCheckBox b = new JCheckBox("버튼 감추기");
        c.add(a);
        c.add(b);
        c.add(btn);

        a.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                    btn.setEnabled(false);
                else
                    btn.setEnabled(true);
            }
        });

        b.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                    btn.setVisible(false);
                else
                    btn.setVisible(true);
            }
        });

        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new week9_1();
    }
}
