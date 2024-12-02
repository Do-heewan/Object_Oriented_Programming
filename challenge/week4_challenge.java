// 영화관 좌석 예약 시스템

package challenge;

import java.util.Scanner;

class MovieTheater {
    private int numRows;
    private int numCols;

    private String seats[][];          // 좌석
    private String reserveName[][][];  // 좌석의 정보(이름, 번호) 저장

    public MovieTheater(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;

        seats = new String[numRows][numCols];
        reserveName = new String[numRows][numCols][2];

        // 좌석 초기화 및 빈 좌석 설정
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                seats[i][j] = "□";
                reserveName[i][j][0] = "";
            }
        }
    }

    // 1. 좌석 조회
    public void displaySeats() {
        System.out.println("----- 영화 좌석 -----");
        System.err.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < numRows; i++) {
            // A, B, C, ... 열을 표현하기 위해 아스키코드로 변환하여 출력
            int aschi = 65 + i;
            char ch = (char)aschi;
            System.out.print(ch + " ");

            for (int j = 0; j < numCols; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 2. 좌석 예약
    public boolean reserveSeat(int row, int col, String name, String phoneNumber) {
        // 이미 예약이 되어있을 경우
        if (seats[row][col - 1].equals("■")) {
            System.out.println("이미 예약된 좌석입니다.");
        }

        // 빈 좌석일 경우 입력받은 정보(이름, 번호)를 저장
        else {
            seats[row][col - 1] = "■";
            reserveName[row][col - 1][0] = name;
            reserveName[row][col - 1][1] = phoneNumber;
            System.out.println("좌석 예약이 완료되었습니다.");
        }
        return true;
    }

    // 3. 좌석 예약 취소
    public void cancelReservation(int row, int col) {
        // 선택한 좌석이 빈좌석일 경우
        if (seats[row][col - 1].equals("□")) {
            System.out.println("선택한 좌석은 예약되지 않았습니다.");
        }

        // 예약좌석일 경우 빈좌석으로 만들고 이름, 번호 정보를 비움
        else {
            seats[row][col - 1] = "□";
            reserveName[row][col - 1][0] = "";
            reserveName[row][col - 1][1] = "";
            System.out.println("좌석 예약 취소가 완료되었습니다.");
        }
    }

    // 4. 예약 정보 조회
    public void displayReservationInfo(String name) {
        int ctn = 0; // 카운트 변수 생성 (반복문이 돌아가는 횟수 카운팅)

        // numRows X numCols 크기의 모든 좌석을 돌면서 입력받은 name과 동일한 좌석의 이름 정보가 있는지 판별
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (reserveName[i][j][0].equals(name)) {
                    System.out.println("좌석 : " + (char)(i + 65) + (char)((j + 1) + 48));
                    System.out.println("이름 : " + reserveName[i][j][0]);
                    System.out.println("전화번호 : " + reserveName[i][j][1]);
                }
                else {
                    // 아닐경우 카운트 증가
                    ctn++;
                }
            }
        }
        // 위의 이중 반복문의 최대 반복 횟수는 numRows * numCols다. 따라서 모든 반복이 else문을 따를 경우 ctn이 최대가 되고 
        // 결국 if문을 따르지 않았기 때문에 조건에 일치하는 정보가 없다는 것이다.
        if (ctn == numRows * numCols) {
            System.out.println("예약자 명과 동일한 예약 정보가 없습니다.");
        }
    }
}

public class Week4_challenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int numRows = 10;
        int numCols = 10;

        MovieTheater movieTheater = new MovieTheater(numRows, numCols);

        while (true) {
            System.out.println("1. 좌석 조회");
            System.out.println("2. 좌석 예약");
            System.out.println("3. 좌석 예약 취소");
            System.out.println("4. 예약 정보 조회");
            System.out.println("5. 종료");
            System.out.print("원하는 작업을 선택하세요 (1/2/3/4/5) : ");

            int choice = s.nextInt();

            switch(choice) {
                // 좌석 조회
                case 1:
                    movieTheater.displaySeats();
                    break;

                // 좌석 예약(reservation)
                case 2:
                    System.out.print("좌석을 예약하려면 행(A, B, C, ...)과 열(1, 2, 3, ...)을 입력하시오. (예 : A2) : ");
                    String seatNum = s.next();

                    // 입력받은 seatNum의 타입은 String, 이를 index 0, 1로 나누어 char로 변환
                    char charRows = seatNum.charAt(0);
                    char charCols = seatNum.charAt(1);

                    // 변환받은 char형을 int형으로 바꾸어 아스키 코드 변환 식을 이용하여 1 ~ 10의 값으로 변형하여 사용
                    numRows = (int)charRows - 65;
                    numCols = (int)charCols - 48;

                    System.out.print("이름을 입력하시오 : ");
                    String name = s.next();

                    System.out.print("전화번호를 입력하시오 : ");
                    String phoneNum = s.next();

                    movieTheater.reserveSeat(numRows, numCols, name, phoneNum);
                    break;

                // 예약 취소(reservation cancel)
                case 3:
                    System.out.print("예약을 취소할 좌석을 입력하세요. (예 : A2) : ");
                    String delSeat = s.next();

                    numRows = (int)delSeat.charAt(0) - 65;
                    numCols = (int)delSeat.charAt(1) - 48;

                    movieTheater.cancelReservation(numRows, numCols);
                    break;

                // 예약자명 정보 조회(reservation info)
                case 4:
                    System.out.println("예약 정보를 조회할 이름을 입력하세요. ");
                    System.out.print("예약 정보 >> ");

                    name = s.next();
                    movieTheater.displayReservationInfo(name);
                    break;

                // 종료 (Exit)
                case 5:
                    System.out.println("프로그램이 종료됩니다.");
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
            }

            // 종료 조건만족 시 while문 종료
            if (choice == 5) {
                break;
            }
        }
        s.close();
    }
}
