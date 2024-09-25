// 로또 번호 6개를 입력 받아 로또 당첨 여부를 확인하는 프로그램

package challenge;

import java.util.Scanner;
import java.util.Arrays;

public class week3_challenge {
    public static void main(String[] args) {
        int userLotto[] = new int[6];

        System.out.println("로또 번호를 입력하시오. (1 ~ 45 사이의 숫자, 중복 없이) : ");
        Scanner s = new Scanner(System.in);

        // 사용자 로또 번호 입력 받기
        for (int i = 0; i < userLotto.length; i++) {
            int num = s.nextInt();
            userLotto[i] = num;

            if (num <= 45 && num > 0) {
                // 중복 확인
                if (i >= 1) {
                    for (int j = 0; j < i; j++) {
                        if (userLotto[j] == num) {
                            i--;
                            System.out.println("중복된 번호입니다. 다시 입력하세요.");
                        }
                    }
                }
            }

            else { // 입력받은 숫자가 45보다 큰 수일 경우 다시 입력
                i--;
                System.out.println("다시 입력하시오.");
            }
        }

        Arrays.sort(userLotto);
        System.out.println("사용자 번호 : " + Arrays.toString(userLotto));

        int winningLotto[] = new int[6];

        // 당첨 로또 생성
        for (int i = 0; i < winningLotto.length; i++) {
            winningLotto[i] = (int)(Math.random() * 44 + 1);

            // 중복 확인
            for (int j = 0; j < i; j++) {
                if (winningLotto[j] == winningLotto[i]) {
                    i--;
                }
            }
        }
        
        Arrays.sort(winningLotto);
        System.out.println("당첨번호 : " + Arrays.toString(winningLotto));

        int count = 0;
        String score;

        // 중복 갯수 세기
        for (int i = 0; i < winningLotto.length; i++) {
            for (int j = 0; j < userLotto.length; j++) {
                if (winningLotto[i] == userLotto[j])
                count++;
            }
        }

        // 중복 갯수에 따라 등수 판별
        if (count == 6)
            score = "1등";
        else if (count == 5)
            score = "2등";
        else if (count == 4)
            score = "3등";
        else if (count == 3)
            score = "4등";
        else
            score = "꽝";

        System.out.printf("%s입니다. 일치하는 번호가 %d개 입니다." , score, count);
        s.close();
    }
}
