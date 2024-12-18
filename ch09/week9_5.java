// 05 JTextArea와 key리스너, JSlider 응용

package ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;

public class week9_5 extends JFrame{
    private JTextArea ta = new JTextArea(5, 10);
    private JSlider slider = new JSlider(0, 100, 0);

    public week9_5() {
        super("TextArea Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(slider, BorderLayout.CENTER);
        c.add(new JScrollPane(ta), BorderLayout.NORTH);

        // 슬라이더 속성
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider s = (JSlider)e.getSource();
                if (ta.getText().length() <= s.getValue())
                    s.setValue(ta.getText().length());
                
                else {
                    try {
                        ta.setText(ta.getText(0, s.getValue()));
                    } catch (BadLocationException el) {}
                }
            }
        });

        ta.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                JTextArea t = (JTextArea)e.getSource();
                int size = t.getText().length();
                try {
                    if (size >= 100) {
                        t.setText(t.getText(0, 100));
                    }
                } catch (BadLocationException ex) {}

                slider.setValue(size);
            }
        });

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new week9_5();
    }
}
