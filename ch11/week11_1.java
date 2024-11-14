// 01 간단한 메뉴 제작하기

package ch11;

import javax.swing.*;

public class week11_1 extends JFrame{
    public week11_1() {
        super("메뉴 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();
        
        setSize(300, 200);
        setVisible(true);
    }

    private void createMenu() {
        JMenu fileMenu = new JMenu("파일");
        JMenu editMenu = new JMenu("편집");
        JMenu viewMenu = new JMenu("보기");
        JMenu inputMenu = new JMenu("입력");

        viewMenu.add(new JMenuItem("화면확대"));
        viewMenu.add(new JMenuItem("쪽윤곽"));

        JMenuBar mb = new JMenuBar();
        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(viewMenu);
        mb.add(inputMenu);

        setJMenuBar(mb);
    }

    public static void main(String[] args) {
        new week11_1();
    }
}