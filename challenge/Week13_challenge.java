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
                StringTokenizer st = new StringTokenizer(line, " ");

                String k_name = st.nextToken(); // 이름 읽기
                String v_number = st.nextToken(); // 전화번호 읽기
                phoneMap.put(k_name, v_number); // 해시맵에 저장
                
                s.close();
            }
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
            
            String phoneNumber = phoneMap.getOrDefault(name, null);
            if (phoneNumber == null) 
                System.out.println("찾는 이름이 없습니다.");
            else 
                System.out.println(phoneNumber);
        }
        // scanner.close();
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
