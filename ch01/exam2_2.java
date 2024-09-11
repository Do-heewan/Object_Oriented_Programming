package ch01;

import java.util.Scanner;

public class exam2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in); // Scanner 객체 생성, 화면으로부터 받기
		System.out.println("두 정수를 입력하시오.");
		
		int num1 = s.nextInt(); // 화면에서 입력받은 정수를 num에 저장
		int num2 = s.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
		System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
		System.out.println(num1 + " % " + num2 + " = " + (num1%num2));
		
		s.close();
		// String input = a.nextLine(); // 화면에서 입력받은 내용을 input에 저장
	}

}
