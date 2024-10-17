// 10 GUI 기본 생성(GUI, Button)

package ch07;

import javax.swing.*;

public class week7_10 {
    public static void createAndShowGUI() {
        // JFrame 객체 생성
        JFrame frame = new JFrame("Two Buttons GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // JFrame 객체 생성 (레이아웃)
        JPanel panel = new JPanel();

        // 첫 번째 JButton 객체 생성
        JButton button1 = new JButton("Button 1");
        button1.addActionListener(e -> {
            System.out.println("버튼 1 선택");
        });

        // 두 번째 JButton 객체 생성
        JButton button2 = new JButton("Button 2");
        button2.addActionListener(e -> {
            System.out.println("버튼 2 선택");
        });

        // 버튼을 패널에 추가
        panel.add(button1);
        panel.add(button2);

        // 패널을 프레임에 추가
        frame.add(panel);

        // 프레임을 화면에 표시
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
}
