package ch12;

import java.util.*;

public class week12_4 {
    public static void main(String[] args) {
        ArrayList<Character> a = new ArrayList<Character>();
        Scanner s = new Scanner(System.in);

        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F) >>");
        for (int i = 0; i < 6; i++) {
            String str = s.next();
            char c = str.charAt(0);
            a.add(c);
        }

        double score = 0.0;
        for (int i = 0; i < a.size(); i++) {
            char c_a = a.get(i);
            switch(c_a) {
                case ('A'):
                    score += 4.0;
                    break;
                case ('B'):
                    score += 3.0;
                    break;
                case ('C'):
                    score += 2.0;
                    break;
                case ('D'):
                    score += 1.0;
                    break;
                case ('F'):
                    score += 0;
                    break;
            }
        }

        System.out.print(score/a.size());
        s.close();
    }
}
