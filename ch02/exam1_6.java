package ch02;

public class exam1_6 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i<=10; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.print("\n");
        System.out.print("sum = " + sum);
    }
}
