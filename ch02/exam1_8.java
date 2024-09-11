package ch02;

import java.util.Scanner;

public class exam1_8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("건너뛸 숫자를 입력하시오. (1 ~ 10 사이) : ");

        int i;
        int n = s.nextInt();
        
        s.close();
        
        for (i = 1; i <= 10; i++) {
            if (n == i)
                continue;
            else
                System.out.print(i + " ");
        }
    }
}
