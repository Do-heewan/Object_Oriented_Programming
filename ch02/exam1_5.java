package ch02;

import java.util.Scanner;

public class exam1_5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("연산식을 입력하시오.");

        int op1 = s.nextInt();
        String op = s.next();
        int op2 = s.nextInt();

        switch(op) {
            case "+":
                System.out.printf("%d %s %d의 결과는 %d", op1, op, op2, op1 + op2);
                break;
            case "-":
                System.out.printf("%d %s %d의 결과는 %d", op1, op, op2, op1 - op2);
                break;
            case "*":
                System.out.printf("%d %s %d의 결과는 %d", op1, op, op2, op1 * op2);
                break;
            case "/":
                System.out.printf("%d %s %d의 결과는 %d", op1, op, op2, op1 / op2);
                break;
        }

        s.close();
    }
}
