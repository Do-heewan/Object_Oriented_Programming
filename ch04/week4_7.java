// 07 Call by Value

package ch04;

import java.util.Scanner;

public class week4_7 {
    public static void data_call(int a, int b) {
        a = a * 10;
        b = b * 10;
        System.out.printf("Call을 수행한 변수의 값 : num1 = %d, num2 = %d\n", a, b);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("첫 번째 숫자를 입력하시오. : ");
        int a = s.nextInt();
        System.out.println("두 번째 숫자를 입력하시오. : ");
        int b = s.nextInt();

        System.out.printf("Call 이전 변수 값: num1 = %d, num2 = %d\n", a, b);
        data_call(a, b);
        System.out.printf("Call 이후 변수 값: num1 = %d, num2 = %d\n", a, b);
        
        s.close();
    }
}
