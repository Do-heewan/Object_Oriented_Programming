// 05 StringTokenizer 클래스

package ch07;

import java.util.*;

public class week7_5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print(">>");
            String text = s.nextLine();
            if (text.equals("Exit")) {
                break;
            }
            
            StringTokenizer st = new StringTokenizer(text, " ");
            System.out.println("어절 개수는 " + st.countTokens());
        }
        s.close();
    }
}
