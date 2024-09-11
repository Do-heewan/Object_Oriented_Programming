package ch02;

import java.util.Scanner;

public class exam1_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("두 정수를 입력하시오.");

        int num1 = s.nextInt();
        int num2 = s.nextInt();

        if (num1 > num2)
            System.out.println(num1 + "이 더 큽니다.");
        else
            System.out.println(num2 + "이 더 큽니다.");

        s.close();
    }
}
