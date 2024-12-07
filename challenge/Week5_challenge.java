package challenge;

import java.util.Scanner;

class GameObject {
    protected int distance; // x + y -> x + 20*y
    protected int x, y;

    public GameObject(int startX, int startY, int distance) {
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean collide(GameObject p) {
        if (this.distance == p.distance)
            return true;
        return false;
    }

    protected void move() {

    }

    protected char getShape() {
        return '-';
    }
}

class PacMan extends GameObject {
    private Scanner scan = new Scanner(System.in);

    public PacMan(int startX, int startY, int distance) {
        super(startX, startY, distance); // super 클래스 상속
    }

    // 메소드 오버라이딩, PacMan의 이동 메소드
    protected void move() {
        System.out.print("왼쪽(a), 위(w), 아래(s), 오른쪽(d) >> ");
        String action = scan.next();

        switch (action) {
            case "w": // Up
                if (x > 0)
                    this.x--;
                break;
            case "s": // Down
                if (x < 9)
                    this.x++;
                break;
            case "a": // Left
                if (y > 0)
                    this.y--;
                break;
            case "d": // Right
                if (y < 19)
                    this.y++;
                break;
            default:
                break;
        }
        this.distance = this.x + 20 * this.y; // 고유 위치값 지정
    }

    protected char getShape() {
        return 'C';
    }
}

class Cookies extends GameObject {
    private int moveCount = 0;

    public Cookies(int startX, int startY, int distance) {
        super(startX, startY, distance); // super 클래스 상속
    }

    // 메소드 오버라이딩, Cookies의 이동 메소드 : 3회 이동마다 랜덤으로 한 칸 이동
    protected void move() {
        this.moveCount++; // 메소드가 호출될 때 마다 count증가

        if (this.moveCount == 3) { // 카운트가 3이 되면, 
            while (true) { // 움직임이 발생할 때 까지 반복
                int action = (int)(Math.random() * 3); // (0 ~ 1) * 3 -> 0 ~ 3 사이의 정수 랜덤 생성
                boolean isChange = false; // 움직임 여부 판별

                switch (action) {
                    case 0: // Up
                        if (this.x - 1 > 0) {
                            this.x--;
                            isChange = true;
                        }
                            
                        break;
                    case 1: // Down
                        if (this.x + 1 < 9) {
                            this.x++;
                            isChange = true;
                        }
                            
                        break;
                    case 2: // Left
                        if (this.y - 1 > 0) {
                            this.y--;
                            isChange = true;
                        }
                            
                        break;
                    case 3: // Right
                        if (this.y + 1 < 19) {
                            this.y++;
                            isChange = true;
                        }
                        break;
                    default:
                        break;
                }

                // 모든 쿠키가 움직였을 경우에만 break
                if (isChange)
                    break;
            }
            this.distance = this.x + 20 * this.y; // 고유 위치값 지정
            this.moveCount = 0; // count 초기화
        }
    }

    protected char getShape() {
        return '●';
    }
}

public class Week5_challenge {
    private char map[][] = new char[10][20];
    private PacMan pacman;
    private Cookies cookies[] = new Cookies[5];
    private int numberofCookies; // 쿠키 생성 갯수
    private int cookieEaten = 0; // 쿠키 획득 갯수

    // 게임 실행 메소드
    public void run() {
        System.out.println("** PacMan 게임에 오신 것을 환영합니다. **");

        pacman = new PacMan(0, 0, 0); // 팩맨 객체 생성
        this.generateCookies(); // 쿠키 생성 메소드 실행
        this.drawMap(); // 맵 그리기

        while (true) { // 맵에 생성된 쿠키를 다 먹을때 까지
            pacman.move();

            this.moveCookies(); // 쿠키 움직임 및 충돌 처리 메소드
            this.drawMap(); // 상태가 바뀔 때 마다 반영

            if (cookieEaten == numberofCookies) // 쿠키를 다 먹으면 게임 종료
                break;
        }
        System.out.println("Clear!! 모든 쿠키를 먹었습니다!!");
    }

    // 쿠키 생성 메소드
    private void generateCookies() {
        numberofCookies = 0;
        int numGen = (int)(Math.random() * 3) + 2; // (0 ~ 1) * 3 -> (0 ~ 3) + 2 -> 2 ~ 5 의 정수 생성

        for (int i = 0; i < numGen; i++) { // 랜덤 생성된 정수 만큼의 쿠키 생성
            int x = (int)(Math.random() * 10); // 좌표 생성
            int y = (int)(Math.random() * 20);

            if ((x == 0) && (y == 0)) // (0, 0)에 생성되었을 경우, 
            {
                i -= 1; // 쿠키 삭제
                continue; // 및 새로 생성을 위해 이후의 코드 건너 뜀
            }
            
            if (this.map[x][y] == '●') // 이미 생성된 위치에 생성되었을 경우,
            {
                i -= 1; // 쿠키 삭제
                continue; // 및 새로 생성을 위해 이후의 코드 건너 뜀
            }
            cookies[i] = new Cookies(x, y, x + y); // 새로운 쿠키 객체 생성
            numberofCookies++; // 쿠키의 수 증가
        }
        System.out.println("생성된 쿠키 수 : " + numberofCookies); // 최종적으로 생성된 쿠키의 수 출력
    }

    private void moveCookies() {
        boolean isEaten = false; // 쿠키를 먹었는지 여부 판단

        for (int i = 0; i < numberofCookies; i++) { // 생성된 모든 쿠키에 대하여
            if (cookies[i] != null) { // 빈 쿠키가 아닐 경우 (획득한 쿠키가 아닐 경우)
                cookies[i].move(); // move() 메소드 호출
                if (cookies[i].collide(pacman)) { // pacman객체와 충돌이 일어났을 경우
                    this.cookieEaten++; // 쿠키 획득 갯수 증가
                    cookies[i] = null; // 빈 쿠키로 바꿈
                    isEaten = true;
                }
            }
        }
        if (isEaten) // 쿠키를 획득했을 경우, 안내 메세지 출력
            System.out.println(cookieEaten + "개 획득!, 남은 쿠키 수 : " + (numberofCookies - cookieEaten));
    }

    // 현재 상태의 맵 호출 메소드
    public void drawMap() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = '-'; // 맵을 표현하기 위해 -로 먼저 채움
            }
        }

        map[this.pacman.getX()][this.pacman.getY()] = this.pacman.getShape(); // pacman 객체 생성 위치(0, 0)에 pacman 그림(C) 지정
        
        for (int i = 0; i < numberofCookies; i++) { // 생성된 쿠키의 수 만큼
            if (this.cookies[i] != null) // 빈 쿠키가 아닐 경우
                map[this.cookies[i].getX()][this.cookies[i].getY()] = this.cookies[i].getShape(); // 쿠키 객체 생성 위치에 쿠키 그림(●) 지정
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(map[i][j]); // 반영된 맵 정보 출력
            }
            System.out.println(); // 10x20 그리드를 표현하기 위함
        }
    }

    public static void main(String[] args) {
        Week5_challenge game = new Week5_challenge();
        game.run();
    }
}
