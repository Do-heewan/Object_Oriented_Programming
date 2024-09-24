// 5,000원 자동 생성 로또 한 장을 생성하는 프로그램 (1 ~ 45 사이의 숫자 6개를 5번 출력하는 프로그램)

package ch03;

import java.util.Arrays;

public class week3_8 {
    public static void main(String[] args) {
        int lotto[] = new int[6];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < lotto.length; j++) {
                lotto[j] = (int)(Math.random() * 45);
            }
    
            // 번호 정렬
            Arrays.sort(lotto);
    
            // 숫자 -> 문자로 표현 (A자동, B자동 ... )
            int num = i + 65;
            char ch = (char)num;

            // 생성된 로또 번호 출력
            System.out.println(ch + "자동 : " + Arrays.toString(lotto));
        }
    }
}
