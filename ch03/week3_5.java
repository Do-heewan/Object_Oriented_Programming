// 주어진 배열을 오름차순과 내림차순으로 정렬하는 프로그램

package ch03;

public class week3_5 {
    public static void main(String[] args) {
        // 정렬할 배열 생성
        int arr[] = {4, 9, 39, 30, 10, 43};
        int temp;

        // 오름차순 정렬 (기본 정렬 사용)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("오름차순 정렬 : ");
        printArray(arr);

        //배열 초기화
        int arr2[] = {4, 9, 39, 30, 10, 43};

        // 내림차순 정렬
        for (int i = 0; i < arr2.length - 1; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[i] < arr2[j]) {
                    temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }

        System.out.println("내림차순 정렬 : ");
        printArray(arr2);
    }

    // 배열을 출력하는 메서드
    public static void printArray(int[] arr) {
        int array[] = arr;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }
}
