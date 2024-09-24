// 4행5열 2차원 배열을 생성하여 0부터 7의 배수를 출력하는 프로그램

package ch03;

public class week3_6 {
    public static void main(String[] args) {
        int array[][] = new int[4][5]; // 4행 5열의 배열 생성

        for (int i = 0; i < array.length; i++) { // 행의 길이만큼 반복
            for (int j = 0; j < array[i].length; j++) { // 열의 길이만큼 반복
                array[i][j] = (5 * i + j) * 7;
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
