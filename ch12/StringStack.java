package ch12;

public class StringStack implements Stack{
    private String element[]; // 스택의 저장 메모리
    private int tos; // index, top of stack

    public StringStack(int capacity) {
        element = new String[capacity];
        tos = -1;
    }

    // Stack 인터페이스에 선언된 다음 3개의 메소드 오버라이딩 구현
    public int length() {
        return tos + 1;
    }

    public int capacity() {
        return element.length;
    }

    public String pop() {
        if (tos == -1)
            return null;
        String s = element[tos];
        tos--;
        return s;
    }   

    public boolean push(String str) {
        if (tos == element.length - 1)
            return false;
        else {
            tos++;
            element[tos] = str;
            return true;
        }
    }
}
