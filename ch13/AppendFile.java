// 04 텍스트 파일 읽기와 쓰기

package ch13;

import java.io.*;
import java.util.Scanner;

public class AppendFile {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FileReader fr = null;
        FileWriter fw = null;

        System.out.println("전체 경로명이 아닌 파일명을 입력 할 경우, 파일은 프로그램과 같은 위치에 있어야 합니다.");

        System.out.print("첫 번째 파일명을 입력하세요 >> ");
        String s1 = s.nextLine();

        System.out.print("두 번째 파일명을 입력하세요 >> ");
        String s2 = s.nextLine();

        try {
            fr = new FileReader(s1); // 첫 번째 파일 스트림 읽기
            fw = new FileWriter("append.txt"); // 합치는 파일 읽기

            writeToFile(fr, fw); // 합치는 파일에 기록
            fr.close(); // 첫 번째 파일 스트림 종료

            fr = new FileReader(s2);  // 두 번째 파일 스트림 열기
            writeToFile(fr, fw); // 합치는 파일에 기록

            fr.close();
            fw.close();

            System.out.println("프로젝트 폴더 밑에 append.txt 파일에 저장하였습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생하였습니다.");
        } 
        s.close();
    }

    private static void writeToFile(FileReader in, FileWriter out) throws IOException {
        char buf[] = new char[50]; // 버퍼 크기 50바이트
        int count = 0; // count는 읽은 문자 개수, while문에 처음 들어가기 위한 임시값
        
        while (true) {
            count = in.read(buf, 0, buf.length);
            if (count == -1)
                break;
            if (count > 0)
                out.write(buf, 0, count);
        }
    }
}
