// 02 메뉴 선택 이벤트 처리, JFileChooser

package ch11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class week11_2 extends JFrame {
    public week11_2() {
        super("메뉴로 배경 이미지 로딩하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        createMenu();

        setSize(400, 400);
        setVisible(true);
    }

    private void createMenu() {
        JMenu fileMenu = new JMenu("파일");
        JMenuItem openFile = new JMenuItem("파일열기");
        fileMenu.add(openFile);
        openFile.addActionListener(new OpenActionListener());

        JMenuBar mb = new JMenuBar();
        mb.add(fileMenu);

        setJMenuBar(mb);
    }

    class OpenActionListener implements ActionListener {
        private JFileChooser chooser;
        public OpenActionListener() {
            chooser = new JFileChooser();
        }

        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
            chooser.setFileFilter(filter);

            int ret = chooser.showOpenDialog(null);
            if (ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String filePath = chooser.getSelectedFile().getPath();
            MyPanel p = (MyPanel) getContentPane();
            ImageIcon icon = new ImageIcon(filePath);
            p.setBgImage(icon.getImage());
        }
    }
    
    class MyPanel extends JPanel {
        private Image bgImg = null;

        public void setBgImage(Image bgImg) {
            this.bgImg = bgImg;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (bgImg == null) {
                return;
            }
            g.drawImage(bgImg, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    public static void main(String[] args) {
        new week11_2();
    }
}
