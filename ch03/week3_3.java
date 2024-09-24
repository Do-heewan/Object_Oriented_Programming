// 금액을 입력받아 각 금액별로 몇 개로 변환되는지 확인하는 프로그램

package ch03;

import java.util.Scanner;

public class week3_3 {
    public static void main(String[] args) {
        int unit[] = {50000, 10000, 1000, 500, 100, 50, 10, 1}; // 환산할 돈의 종류

        System.out.print("금액을 입력하시오 >> ");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int[] result = new int[8]; // 몫(num을 각 금액으로 나눈 값)을 저장할 배열 생성
        for (int i = 0; i < unit.length; i++) {
            result[i] = num / unit[i]; // 각 금액의 갯수 = 몫
            num = num % unit[i]; // 금액으로 나눈 나머지를 다시 num에 저장하여 계산 반복
            
            if (result[i] != 0) // 0개인 금액은 출력하지 않음
                System.out.println(unit[i] + "원 짜리 : " + result[i] + "개");
        }

        s.close();
    }
}
