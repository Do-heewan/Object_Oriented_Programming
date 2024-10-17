// 04 StringBuffer 클래스

package ch07;

import java.util.Scanner;

public class week7_4 {
    public static void main(String[] args) {
        System.out.print(">>");
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        StringBuffer sb = new StringBuffer(text);

        while (true) {
            sb.append(text);
            System.out.print("명령 : ");
            String new_text = s.nextLine();

            if (new_text.equals("그만")) {
                break;
            }
            String new_texts[] = new_text.split("!");

            if (new_texts.length != 2) {
                System.out.println("잘못된 명령입니다.");
                continue;
            }

            System.out.println(new_texts[1] + text.substring(new_texts[0].length()));
        }
        s.close();
    }
}
