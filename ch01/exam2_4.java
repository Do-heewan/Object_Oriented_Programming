package ch01;

import java.util.Scanner;

public class exam2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min;
		Scanner s = new Scanner(System.in);
		System.out.print("정수 3개를 입력하시오.");
		
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		
		if (a < b)
			min = a;
		else if (b < c)
			min = b;
		else
			min = c;
		
		System.out.print("가장 작은 수는 : " + min);
		
		/*
		min = a < b ? a : b;
		min = min < z ? min : z;
		System.out.print("가장 작은 수는 : " + min);
				*/
		
		s.close();
	}

}
