package ch02;

import java.util.Scanner;

public class exam1_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("숫자를 입력하시오.");

        int num = s.nextInt();

        if (num % 2 == 0)
            System.out.println("짝수입니다.");
        else
            System.out.print("홀수입니다.");

        s.close();
    }
}
