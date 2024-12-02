// 로또 번호 6개를 입력 받아 로또 당첨 여부를 확인하는 프로그램

package challenge;

import java.util.Scanner;
import java.util.Arrays;

public class Week3_challenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 사용자 로또 생성
        int userLotto[] = new int[6];
        for (int i = 0; i < userLotto.length; i++) {
            System.out.print("로또 번호를 입력하시오. (1 ~ 45 사이의 숫자, 중복 없이) : ");
            
            int num = s.nextInt();
            userLotto[i] = num;

            // 입력 숫자 제한 (1 ~ 45 사이의 숫자)
            if (num <= 45 && num > 0) { 
                // 중복 확인
                if (i >= 1) { // 인덱스 1번부터 시작
                    for (int j = 0; j < i; j++) { // 인덱스 0번 부터 입력 받은 순간까지 탐색
                        if (userLotto[j] == num) { // 중복된 수가 있을 경우
                            i--; // 입력받은 수를 i번째 인덱스에 저장하지 않고, 다시 i번째 인덱스에 수를 받기위해 i-1을 함.
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

        // 사용자 번호 정렬
        Arrays.sort(userLotto);

        // 당첨 로또 생성
        int winningLotto[] = new int[6];
        for (int i = 0; i < winningLotto.length; i++) {
            winningLotto[i] = (int)(Math.random() * 44 + 1); // (0 ~ 44 사이의 수 + 1) => 1 ~ 45 사이의 숫자가 생성되도록 한다.

            // 중복 확인
            for (int j = 0; j < i; j++) { // i번 인덱스 까지 탐색
                if (winningLotto[j] == winningLotto[i]) { // i번째 생성된 랜덤 수가 배열 내 있을 경우
                    i--; // 저장하지 않고 인덱스 i번째 부터 다시 랜덤 생성하도록 함
                }
            }
        }
        
        // 당첨 번호 정렬
        Arrays.sort(winningLotto);

        // 로또 번호 출력
        System.out.println("사용자 번호 : " + Arrays.toString(userLotto));
        System.out.println("당첨번호 : " + Arrays.toString(winningLotto));

        // 중복 갯수와 등수 저장
        int count = 0;
        String score;

        // 중복 갯수 세기
        for (int i = 0; i < winningLotto.length; i++) {
            for (int j = 0; j < userLotto.length; j++) {
                if (winningLotto[i] == userLotto[j]) // 이중 반복문을 이용하여 탐색 후
                count++; // 같은 번호가 있을 경우 count 증가
            }
        }

        // 중복 갯수에 따라 등수 판별
        switch(count) {
            case(6):
                score = "1등";
                break;
            case(5):
                score = "2등";
                break;
            case(4):
                score = "3등";
                break;
            case(3):
                score = "4등";
                break;
            default:
                score = "꽝";
                break;
        }

        System.out.printf("%s입니다. 일치하는 번호가 %d개 입니다." , score, count);
        s.close();
    }
}
