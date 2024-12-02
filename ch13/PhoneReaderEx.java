// 02 FileReader로 텍스트 파일 읽기

package ch13;

import java.io.*;

public class PhoneReaderEx {
    public static void main(String[] args) {
        FileReader fr = null;
        File f = new File("C://Users/Noh/JAVA/src/ch13/phone.txt");

        try {
            fr = new FileReader(f);
            int c;

            while ((c = fr.read()) != -1) {
                System.out.print((char)c);
            }

            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}