package ch01;

import java.util.Scanner;

public class exam2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double pi = 3.141592;
		
		Scanner s = new Scanner(System.in);
		System.out.print("구의 반지름 : ");
		int r = s.nextInt();
		
		double V = (4 * pi * r * r * r)/3;
		System.out.printf("구의 부피 : %.2f", V);

		s.close();
	}

}
