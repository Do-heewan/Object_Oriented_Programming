package challenge;

import java.util.Scanner;

public class week2_challenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("현재 시간을 입력하시오 (HH 형식, 00 ~ 23) : "); // 00시 부터 23시 까지 입력 받도록 한다.
        int h = s.nextInt(); // 입력받은 시간을 h 변수에 저장

        System.out.println("현재 분을 입력하시오 (mm 형식, 00 ~ 59) : "); // 00분 부터 59분 까지 입력 받도록 한다.
        int m = s.nextInt(); // 입력받은 분을 m 변수에 저장

        if (h < 24 && m < 60) { // h가 24보다 작고, m은 60보다 작을 때,
            if (h > 9) { // 현재 시간이 9시 이후일 경우, 즉 알람이 울리고 난 후 몇시간 지났는지
                h = h - 9;
                System.out.printf("알람이 울린 후 %d시간 %d분 지났습니다.", h, m);
            }
            else if (h < 9) { // 현재 시간이 9시 이전일 경우, 즉 알람이 울리기까지 얼마나 남았는지
                if (m == 0) { // m이 0, 즉 정시일 경우
                    h = 9 - h;
                    System.out.printf("알람이 울리기 까지 %d시간 %d분 남았습니다.", h, m);
                }
                else { // m이 0이 아닐 경우, h에서 한 시간을 더 빼야하고, 60에서 m을 빼주어야 한다.
                    h = 9 - h - 1;
                    m = 60 - m;
                    System.out.printf("알람이 울리기 까지 %d시간 %d분 남았습니다.", h, m);
                }
            }
            else if (h == 9) { // 09시 ~~분 일 경우
                if (m == 0) { // 09시 00분 일 경우, 알람이 울린다.
                    System.out.println("알람이 울립니다. 따르릉따르릉");
                }
                else { // 그 밖의 경우
                    System.out.printf("알람이 울린 후 %d분 지났습니다.", m);
                }
            }
        }
        else { // h 또는 m이 양식에 맞지 않는 숫자가 입력 받았을 경우 
            System.out.println("다시 입력해주세요.");
        }

        s.close();
    }
}
