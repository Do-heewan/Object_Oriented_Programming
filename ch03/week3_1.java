// 1 ~ 5 까지 1차원 배열을 생성하고 출력하는 프로그램

package ch03;

public class week3_1 {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5}; // 배열 생성

        System.out.print("배열 >> ");
        for (int i = 0; i < array.length; i++) { 
            System.out.print(array[i] + " " ); // 배열의 원소를 출력하기 위해 배열의 길이만큼 반복한 후 원소를 하나씩 출력
        }
        System.out.print("\n");
        for (int j = 0; j < array.length; j++) {
            System.out.printf("인덱스 %d : %d\n", j, array[j]); // 배열의 길이만큼 반복하여 인덱스에 해당하는 원소를 출력
        }
    }
} 
