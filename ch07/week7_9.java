// 09 Calendar 객체

package ch07;

import java.util.Calendar;
import java.util.Scanner;

public class week7_9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 사용자로부터 기념일 입력 받기
        System.out.print("기념일을 입력하시오 : ");
        String date = s.nextLine();

        // 입력된 기념일을 Calendar 객체로 변환
        Calendar anniversary = parseDate(date);

        // 현재 날짜 및 시간 가져오기
        Calendar now = Calendar.getInstance();
        System.out.println("현재 날짜 및 시간 : " + now.getTime());

        // 두 날짜 간의 차이 계산
        long daysDifference = calculateDaysDifference(now, anniversary);
        System.out.println("기념일까지 남은 날짜 : " + daysDifference + "일");

        s.close();
    }

    private static Calendar parseDate(String dateInput) {
        try {
            String dateParts[] = dateInput.split("-");
    
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]) - 1; // Calendar 클래스의 월은 0부터 시작하므로 1을 빼줌
            int day = Integer.parseInt(dateParts[2]);
    
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
    
            return calendar;
        }
        
        catch (Exception e) {
            System.err.println("잘못된 날짜 형식입니다. 프로그램을 종료합니다.");
            System.exit(1);
            return null;
        }
    }

    private static long calculateDaysDifference(Calendar date1, Calendar date2) {
        long diffMillis = date2.getTimeInMillis() - date1.getTimeInMillis();
        return diffMillis / (24 * 60 * 60 * 1000);
    }
}




