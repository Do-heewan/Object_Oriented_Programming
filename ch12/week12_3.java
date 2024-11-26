package ch12;

import java.util.Scanner;

public class week12_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("총 스택 저장 공간의 크기 입력 >>");
        int n = s.nextInt();

        StringStack ss = new StringStack(n); // n개의 문자열이 저장 가능한 스택 생성

        while(true) {
            System.out.println("문자열 입력 >>");
            String str = s.next();
            if (str.equals("Exit"))
                break;
            boolean res = ss.push(str); // 스택에 저장
            if (res == false)
                System.out.println("스택이 꽉 차서 푸시 불가!");
        }

        System.out.print("스택에 저장된 모든 문자열 팝 : ");
        int len = ss.length();

        for (int i = 0; i < len; i++) {
            System.out.print(ss.pop() + " ");
        }

        s.close();
    }
}
