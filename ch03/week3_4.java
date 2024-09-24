// 1 ~ 100 사이의 임의의 양의 정수 10개를 가지는 배열을 생성하는 메서드를 작성하고, 해당 메서드로 부터 배열을 리턴 받아 출력하는 프로그램

package ch03;

public class week3_4 {
    public static void main(String[] args) {
        // 양의 정수 10개를 랜덤하게 생성한 배열 받기
        int array[] = generateRandomIntArray(10);

        //받은 배열 출력
        System.out.println("생성된 배열 : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // 양의 정수 10개를 랜덤하게 생성하여 배열로 반환하는 메서드
    public static int[] generateRandomIntArray(int length) {
        int randomArray[] = new int[length]; // length 크기 만큼 배열 생성

        for (int i = 0; i < length; i++) {
            randomArray[i] = (int)(Math.random()*100); // 배열의 크기(length)에 맞게 랜덤한 수 지정
        }

        return randomArray;
    }
}
