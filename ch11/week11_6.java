// 06 static 메소드 호출하기, 배열

package ch11;

import java.util.Scanner;

class Dictionary {
    private static String kor[] = {"사랑", "아기", "돈", "미래", "희망"};
    private static String eng[] = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (word.equals(kor[i]))
                return eng[i];
        }
        return null;
    }
}

public class week11_6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in, "EUC-KR");

        System.out.println("한영 단어 검색 프로그램입니다.");
        
        while (true) {
            System.out.print("한글단어?");
            String word = s.next();
            
            if (word.equals("그만"))
                break;

            String eng_word = Dictionary.kor2Eng(word);
            if (eng_word == null)
                System.out.println(word + "는 저의 사전에 없습니다.");
            else
                System.out.println(word + "는 " + eng_word);
        }

        s.close();
    }
}
