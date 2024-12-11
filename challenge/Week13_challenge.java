package challenge;

import java.io.*;
import java.util.*;

public class Week13_challenge {
    private String fileName = "c:/Upload/phone.txt"; // 경로 수정
    private HashMap<String, String> phoneMap = new HashMap<String, String>();

    public Week13_challenge() { }

    private void readPhoneFile() {
        try {
            Scanner s = new Scanner(new FileReader(new File(fileName)));
            while (s.hasNext()) {
                String line = s.nextLine();
                StringTokenizer st = new StringTokenizer(line, " "); // 공백을 기준으로 split

                String k_name = st.nextToken(); // 이름 읽기
                String v_number = st.nextToken(); // 전화번호 읽기
                phoneMap.put(k_name, v_number); // 해시맵에 저장
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("총 " + phoneMap.size() + "개의 전화번호를 읽었습니다.");
    }

    private void processQuery() {
        Scanner scanner = new Scanner(System.in, "MS949"); // 한글 인코딩 깨짐 문제 해결
        
        while (true) {
            System.out.print("이름 >>");
            String name = scanner.nextLine();

            if (name.equals("그만"))
                break;

            if (name.equals("추가")) {
                addName(); // 이름, 전화번호 추가 메소드 호출
                continue;
            }

            if (name.equals("삭제")) {
                removeName(); // 이름, 전화번호 삭제 메소드 호출
                continue;
            }
            
            String phoneNumber = phoneMap.getOrDefault(name, null);
            if (phoneNumber == null) 
                System.out.println("찾는 이름이 없습니다.");
            else 
                System.out.println(phoneNumber);
        }
        scanner.close();
    }

    // 이름, 전화번호 추가 메소드
    private void addName() {
        Scanner add = new Scanner(System.in, "MS949");

        while (true) {
            System.out.print("이름 전화번호 >> ");
            String line = add.nextLine();
            if (line.equals("추가그만"))
                break;

            StringTokenizer st = new StringTokenizer(line, " ");

            // 이름과 전화번호를 입력받아 해시맵에 저장

            String k_name = st.nextToken(); // 이름 읽기
            String v_number = st.nextToken(); // 전화번호 읽기
            phoneMap.put(k_name, v_number); // 해시맵에 저장
            System.out.println("성공적으로 추가되었습니다.");
        }
        System.out.println("총 " + phoneMap.size() + "개의 전화번호를 읽었습니다.");
    }

    // 이름, 전화번호 삭제 메소드
    private void removeName() {
        Scanner remove = new Scanner(System.in, "MS949");

        while (true) {
            System.out.print("삭제 할 이름 >> "); // 해시맵의 Key 삭제시 Value도 함께 삭제됨
            String line = remove.nextLine();
            if (line.equals("삭제그만"))
                break;

            phoneMap.remove(line); // 해시맵 Key(name) 에서 삭제
            System.out.println("성공적으로 삭제되었습니다.");
        }
        System.out.println("총 " + phoneMap.size() + "개의 전화번호를 읽었습니다.");
    }

    public void run() {
        readPhoneFile();
        processQuery();
    }

    public static void main(String[] args) {
        Week13_challenge phoneExplorer = new Week13_challenge();
        phoneExplorer.run();
    }
}
