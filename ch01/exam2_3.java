package ch01;

import java.util.Scanner;
public class exam2_3 {
	public static void main(String[] args) {
		final double rate = 1310.0;
		
		Scanner s = new Scanner(System.in);
		System.out.print("원화를 입력하세요(단위 원)");
		int num = s.nextInt();
		
		double result = num / rate;
		System.out.printf("%d원은 $%.2f입니다.", num, result);

		s.close();
	}
}
