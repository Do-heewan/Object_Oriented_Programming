package challenge;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

class NorthPanel1 extends JPanel {
    public NorthPanel1(JTextField inputText) {
        setLayout(new FlowLayout());
        setBackground(Color.gray);

        JLabel label = new JLabel("수식입력");
        label.setForeground(Color.BLACK);

        JTextField tf = inputText;
        tf.setEditable(false);

        add(label);
        add(tf);
    }
}

class CenterPanel1 extends JPanel {
    public CenterPanel1() {
        setLayout(new GridLayout(4, 4, 5, 5));
    }
}

class SouthPanel1 extends JPanel {
    public SouthPanel1(JTextField outputText) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel("계산결과");
        label.setForeground(Color.white);

        JTextField tf = outputText;
        tf.setEditable(false);

        add(label);
        add(tf);
    }
}

public class Week9_challenge extends JFrame implements ActionListener{
    JTextField input = new JTextField(17);
    JTextField output = new JTextField(15);

    public Week9_challenge() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        CenterPanel1 centerPanel = new CenterPanel1();

        String buttons[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "CE", "계산", "+", "-", "x", "/"};
        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]);
            if (i > 11) {
                button.setBackground(Color.yellow);
            }
            button.addActionListener(this);
            centerPanel.add(button);
        }

        c.setLayout(new BorderLayout());
        c.add(new NorthPanel1(input), BorderLayout.NORTH);
        c.add(centerPanel, BorderLayout.CENTER);
        c.add(new SouthPanel1(output), BorderLayout.SOUTH);
        setSize(300, 300);
        setVisible(true);
    }

    // 연산자 우선순위 반환
    public static int getOpPriority(char c){
        switch (c) {
            case 'x':
            case '/':
                return 3;

            case '+':
            case '-':
                return 2;

            case '(':
                return 1;

            default:
                return -1;
        }
    }

    // 연산자 우선순위 비교
    public static int compareOp(char stackOp, char curOp){
        int stackOpPriority = getOpPriority(stackOp);
        int curOpPriority = getOpPriority(curOp);

        // 현재 우선순위가 더 높은 경우
        if (stackOpPriority < curOpPriority){
            return 1;
        }
        // 우선순위가 같은 경우
        else if (stackOpPriority == curOpPriority){
            return 0;
        }
        // 스택의 우선순위가 더 높은 경우
        else {
            return -1;
        }
    }

    public static String convPostfix(String infix){
        char c = ' ';
        Stack<Character> opStack = new Stack<Character>();
        StringBuffer sb = new StringBuffer();
    
        for(int i=0; i<infix.length(); i++){
            c = infix.charAt(i);
    
            // 숫자이면 표현
            if (Character.isDigit(c)){
                sb.append(c);
            }
            // 연산자 스택이 비어있을 경우 값 push
            else if (opStack.isEmpty()){
                opStack.push(c);
            }
            // 숫자가 아니고 연산자 스택이 비어있지 않은 경우 (연산자가 하나라도 스택에 추가된 경우)
            else {
                // 여는 괄호가 나오면 스택에 저장 후 다음 문자로
                if (c == '('){
                    opStack.push(c);
                    continue;
                }
                // 닫는 괄호가 나올 경우
                // 스택에 저장된 모든 연산자를 반환
                else if (c == ')'){
                    char check = ' ';
                    while(true) {
                        check = (char) opStack.pop();
                        if (check == '(') {
                            break;
                        }
                        else {
                            sb.append(check);
                        }
                    }
                    continue;
                }
    
                // 현재 연산자의 우선순위가 더 높은 경우
                // 스택에 연산자 저장
                if (compareOp((char)opStack.peek(), c) > 0){
                    opStack.push(c);
                }
                // 현재 연산자의 우선순위가 더 낮거나 같은 경우
                // 스택에 있는 우선순위가 높은 연산자를 빼서 표현
                else {
                    while(!opStack.isEmpty()){
                        if (compareOp((char)opStack.peek(), c) <= 0){
                            sb.append(opStack.pop());
                        }
                        else {
                            break;
                        }
                    }
                    opStack.push(c);
                }
            }
        }
    
        char check = ' ';
        while(!opStack.isEmpty()) {
            check = (char) opStack.pop();
            if (check != '(') {
                sb.append(check);
            }
        }
        System.out.println(sb.toString());
    
        return sb.toString();
    }

    public static double postfixCalculate(String postfix){
        Stack<String> stack = new Stack<String>();
        char c = ' ';
        double op1 = 0;
        double op2 = 0;
        
        for(int i=0; i<postfix.length(); i++){
            c = postfix.charAt(i);
    
            // 숫자인 경우 스택에 저장
            if (Character.isDigit(c)){
                stack.push(String.valueOf(c));
            }
            // 연산자인 경우 계산 후 스택에 저장
            else {
                op2 = Double.valueOf(stack.pop().toString());
                op1 = Double.valueOf(stack.pop().toString());
    
                switch (c){
                    // op2에 먼저 pop한 이유는 후위 표기법으로 변환할 때 순서가 바뀌기 때문
                    // ex) 3+2 => 스택에 저장 시 3, 2 순으로 저장되는데 스택은 마지막에 push한
                    // 데이터가 가장 위에 있으므로
                    case '+':
                        stack.push(String.valueOf(op1 + op2));
                        break;
    
                    case '-':
                        stack.push(String.valueOf(op1 - op2));
                        break;
    
                    case 'x':
                        stack.push(String.valueOf(op1 * op2));
                        break;
    
                    case '/':
                        stack.push(String.valueOf(op1 / op2));
                        break;
                }
            }
        }
    
        return Double.valueOf(stack.pop().toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btText = ((JButton)e.getSource()).getText();
        String postfix;
        double result;

        switch (btText){
            case "계산":
                postfix = convPostfix(this.input.getText());
                result = postfixCalculate(postfix);
                
                this.output.setText(String.valueOf(result));
                
                break;

            case "CE":
                this.input.setText("");
                this.output.setText("");
                break;

            default:
                this.input.setText(this.input.getText() + btText);
                break;
        }
    }

    public static void main(String[] args) {
        new Week9_challenge();
    }
}
