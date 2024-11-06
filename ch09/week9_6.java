// 06 스윙 컴포넌트와 이벤트의 종합 응용

package ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class week9_6 extends JFrame{
    private ImageIcon [] gbbImage = {
        new ImageIcon("images/gawi.jpg"),
        new ImageIcon("images/bawi.jpg"),
        new ImageIcon("images/bo.jpg")
    };
    private static String SAME = "Same !!!";
    private static String ME_WINNER = "ME !!!!";
    private static String COM_WINNER = "Computer !!!";
    
    private MenuPanel menuPanel = new MenuPanel();
    private GamePanel gamePanel = new GamePanel();

    public week9_6() {
        super("가위바위보 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        add(menuPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
    }

    class MenuPanel extends JPanel {
        private JButton[] gbbBtn = new JButton[3];
        public MenuPanel() {
            setBackground(Color.GRAY);
            for (int i = 0; i < gbbBtn.length; i++) {
                gbbBtn[i] = new JButton(gbbImage[i]);
                add(gbbBtn[i]);

                gbbBtn[i].addActionListener(new MyActionListener());
            }
        }
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton)e.getSource();
            int computerPart = (int)(Math.random() * 3);

            String winner = SAME;

            if (btn.getIcon() == gbbImage[0] && computerPart == 2 || 
                btn.getIcon() == gbbImage[1] && computerPart == 0 ||
                btn.getIcon() == gbbImage[2] && computerPart == 1)
                winner = ME_WINNER;
            else if (btn.getIcon() == gbbImage[0] && computerPart == 1 || 
                    btn.getIcon() == gbbImage[1] && computerPart == 2 ||
                    btn.getIcon() == gbbImage[2] && computerPart == 0)
                winner = COM_WINNER;
            else
                winner = SAME;

            gamePanel.draw(btn.getIcon(), gbbImage[computerPart], winner);
        }
    }

    class GamePanel extends JPanel {
        private JLabel me = new JLabel("me");
        private JLabel com = new JLabel("computer");
        private JLabel winner = new JLabel("winner");

        public GamePanel() {
            setBackground(Color.YELLOW);
            add(me);
            add(com);
            add(winner);
            winner.setForeground(Color.RED);
        }

        public void draw(Icon myImage, Icon computerImage, String w) {
            me.setIcon(myImage);
            com.setIcon(computerImage);
            winner.setText(w);
        }
    }

    public static void main(String[] args) {
        new week9_6();
    }
}
