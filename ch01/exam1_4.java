package ch01;

public class exam1_4 {
	public static void main(String[] args) {
		int a = 3;
		double b = 10.123;
		System.out.println(a + " + " + b + " = " + (a + b));
		System.out.println(a + " - " + b + " = " + (a - b));
		System.out.println(a + " * " + b + " = " + (a * b));
		System.out.println(a + " / " + b + " = " + (a / b));

		System.out.printf("%d + %f = %.3f \n", a, b, a+b);
		System.out.printf("%d - %f = %.3f \n", a, b, a-b);
		System.out.printf("%d * %f = %.5f \n", a, b, a*b);
		System.out.printf("%d / %f = %.7f \n", a, b, a/b);
	}
}
