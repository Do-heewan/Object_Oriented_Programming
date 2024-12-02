// 05 File클래스로 파일 리스트, 크기 알아내기

package ch13;

import java.io.*;

public class FileSize {
    public static void main(String[] args) {
        File file = new File("C://");
        File files[] = file.listFiles();

        long bigSize = 0;
        File bigFile = null;

        for (int i = 0; i < files.length; i++) {
            file = files[i];

            if (!file.isFile()) // 파일이 아닌 경우(디렉토리인 경우)
                continue;
            
            long size = file.length();
            if (bigSize < size) { // 크기 비교
                bigSize = size;
                bigFile = file;
            }
        }

        if (bigFile == null) 
            System.out.println("파일은 없습니다.");
        else
            System.out.println("가장 큰 파일은 " + bigFile.getPath() + " " + bigSize + "바이트");
    }
}
