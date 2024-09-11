package ch02;

import java.util.Scanner;

public class exam1_9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while(true) {
            System.out.println("숫자를 입력하시오.");
            int a = s.nextInt();
            System.out.println("입력한 숫자 : " + a);

            if (a == 10)
                break;
            else
                continue;
        }
        System.out.println("프로그램을 종료합니다.");

        s.close();
    }
}
