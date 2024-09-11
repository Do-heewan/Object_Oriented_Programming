package ch02;

import java.util.Scanner;

public class exam1_4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("정수 3개를 입력하시오.");

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        if (a*a > b*b + c*c)
            System.out.println("삼각형이 될 수 있습니다.");
        else if (b*b > a*a + c*c)
            System.out.println("삼각형이 될 수 있습니다.");
        else if (c*c > a*a + b*b)
            System.out.println("삼각형이 될 수 있습니다.");
        else
            System.out.println("삼각형이 될 수 없습니다.");

        s.close();
    }
}
