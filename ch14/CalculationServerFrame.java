package ch14;

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class CalculationServerFrame extends JFrame {
    private JTextArea log = new JTextArea();
    public CalculationServerFrame() {
        super("멀티스레드 계산 서버");
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.add(new JLabel("계산 서버 입니다."));
        c.add(new JScrollPane(log), BorderLayout.CENTER);
        setVisible(true);

        new ServerThread().start();
    }

    class ServerThread extends Thread {
        public void run() {
            ServerSocket listener = null;
            Socket socket = null;

            try {
                listener = new ServerSocket(9998);
                while (true) {
                    socket = listener.accept();
                    log.append("클라이언트 연결됨\n");
                    new ServiceThread(socket).start();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }

            try {
                if (listener != null)
                    listener.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class ServiceThread extends Thread {
        private BufferedReader in = null;
        private BufferedWriter out = null;

        public ServiceThread(Socket socket) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            while (true) {
                try {
                    String num1 = in.readLine();
                    String op = in.readLine();
                    String num2 = in.readLine();

                    int a = Integer.parseInt(num1);
                    int b = Integer.parseInt(num2);

                    String res = "";
                    int result = 0;
                    switch (op) {
                        case ("+"):
                            result = a + b;
                            res = Integer.toString(result);
                            break;
                        case ("-"):
                            result = a - b;
                            res = Integer.toString(result);
                            break;
                        case ("x"):
                            result = a * b;
                            res = Integer.toString(result);
                            break;
                        case ("/"):
                            result = a / b;
                            res = Integer.toString(result);
                            break;
                        default:
                            break;
                    }
                    out.write(res + "\n");
                    log.append(a + op + b + " = " + res);
                } catch (IOException e) {
                    log.append("연결 종료");
                    System.out.println("연결 종료");
                    return;
                }
            }
        }
        public static void main(String[] args) {
            new CalculationServerFrame();
        }
    }
}
