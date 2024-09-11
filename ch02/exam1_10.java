package ch02;

public class exam1_10 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 9; j > 0; j--) {
                System.out.printf("%d X %d = %d\t", j, i, i * j);
            }
            System.out.print("\n");
        }
    }
}
