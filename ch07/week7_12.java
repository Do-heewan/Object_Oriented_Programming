// 12 GUI 기본 생성(GUI, Button)

package ch07;

import javax.swing.*;

public class week7_12 {
    private static JFrame frame;
    private static JPanel panel;
    private static int buttonCount = 2;

    public static void createAndShowGUI() {
        frame = new JFrame("Dynamic Buttons GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        panel = new JPanel();

        JButton addButton = new JButton("Add Button");
        addButton.addActionListener(e -> {
            addNewButton();
        });

        JButton removeButton = new JButton("Remove Button");
        removeButton.addActionListener(e -> {
            removeLastButton();
        });

        panel.add(addButton);
        panel.add(removeButton);

        frame.add(panel);

        frame.setVisible(true);
    }

    private static void addNewButton() {
        JButton newButton = new JButton("Button " + (++buttonCount));
        panel.add(newButton);
        frame.pack();
        frame.setVisible(true);
    }

    private static void removeLastButton() {
        if (buttonCount > 2) {
            panel.remove(--buttonCount);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
}
