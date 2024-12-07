package ch14;

import java.io.*;
import java.net.*;
import java.util.*;

public class TimeClient {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BufferedReader in = null;
        Socket socket = null;

        try {
            socket = new Socket("localhost", 9999);
            System.out.println("서버에 접속하였습니다...");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputMessage;
            while (true) {
                inputMessage = in.readLine();

                if (inputMessage == null || inputMessage.equalsIgnoreCase("끝")) {
                    System.out.println("\n연결을 종료합니다.");
                    break;
                }
                else {
                    int n = Integer.parseInt(inputMessage);
                    System.out.println(n + " ");
                }
            }
            socket.close();
            s.close();
        } catch (IOException e) {
            System.out.println("입출력 오류 발생");
        }
    }
}
