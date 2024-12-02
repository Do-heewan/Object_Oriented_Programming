// 03 텍스트 파일 읽기, Scanner와 FileReader

package ch13;

import java.io.*;
import java.util.Scanner;

public class LineNumber {
    public static void main(String[] args) {
        System.out.println("C://windows/system.ini 파일을 읽어 출력합니다.");
        try {
            File f = new File("C://windows/system.ini");
            Scanner fScanner = new Scanner(f);

            int lineNumber = 1;
            while (fScanner.hasNext()) {
                String line = fScanner.nextLine();
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            fScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("입출력 오류가 발생하였습니다.");
        }
    }
}
