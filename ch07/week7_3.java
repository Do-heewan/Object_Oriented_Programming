// 03 substring()

package ch07;

import java.util.Scanner;

public class week7_3 {
    public static void main(String[] args) {
        System.out.println("문자를 입력하시오.");
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();

        for (int i = 1; i < text.length() + 1; i++) {
            String new_text = text.substring(i);
            String back_text = text.substring(0, i);
            System.out.println(new_text + back_text);
        }

        s.close();
    }
}
