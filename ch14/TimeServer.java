package ch14;

import java.io.*;
import java.net.*;

public class TimeServer {
    public static void main(String[] args) {
        BufferedWriter out = null;
        ServerSocket listener = null;
        Socket socket = null;
        System.out.println("타임 서버입니다.");

        try {
            listener = new ServerSocket(9999);
            socket = listener.accept();
            System.out.println("연결되었습니다.\n 500ms마다 수를 보냅니다.");

            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            TimerThread th = new TimerThread(out);
            th.start();

            try {
                th.join();
            } catch (InterruptedException e) {
                socket.close();
                listener.close();
                System.out.println("종료합니다.");
            }
        } catch (IOException e) {
            System.out.println("입출력 오류 발생");
        }
    }
}

class TimerThread extends Thread {
    private BufferedWriter out;
    public TimerThread(BufferedWriter out) {
        this.out = out;
    }

    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                sleep(500);
                out.write(Integer.toString(i) + "\n");
                out.flush();
            }
            out.write("끝\n");
            out.flush();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}