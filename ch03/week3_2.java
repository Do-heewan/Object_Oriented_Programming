// 과목 이름을 입력 받아 학점을 출력하는 프로그램

package ch03;

import java.util.Scanner;

public class week3_2 {
    public static void main(String[] args) {
        String course[] = {"Objected", "Programming", "Algorithm", "Structure", "Computer"};
        char score[] = {'A', 'B', 'B', 'C', 'D'};

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("강의 이름을 입력하시오. >>");
            String cour = s.next();

            int i;
            for (i = 0; i<course.length; i++) { // for문을 이용해 course[] 배열 안의 원소를 모두 탐색
                if(cour.equals(course[i])) { // if문을 이용해 입력받은 값과 배열 내부의 원소 값과 같은지 체크
                    System.out.println(course[i] + "의 학점은 " + score[i]);
                    break; // cour == course의 원소일 경우 for문을 빠져나감
                }
            }

            if (cour.equals("Exit")) { // Exit를 입력할 시 프로그램 종료
                System.out.println("종료되었습니다.");
                break;
            }
            
            if (i == course.length) { // 위의 for문을 모두 반복하면 i = 5, for문을 모두 반복했다는 것은 course[i]와 동일하지 않다는 것이기 때문에 존재하지 않는 강의
                System.out.println("존재하지 않는 강의입니다.");
            }
        }
        s.close();
    }
}
