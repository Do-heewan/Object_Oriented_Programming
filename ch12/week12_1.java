package ch12;

import java.util.Scanner;

abstract class Converter {
    abstract protected double convert(double src); // 추상 메소드
    abstract protected String srcString();
    abstract protected String destString();
    protected double ratio; // 비율

    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println(srcString() + "을" + destString() + "으로 바꿉니다.");
        System.out.print(srcString() + "을 입력하세요>>");

        double val = s.nextDouble();
        double res = convert(val);

        System.out.println("반환결과 : " + res + destString() + "입니다.");
        s.close();
    }
}

public class week12_1 extends Converter{
    week12_1(double ratio) {
        this.ratio = ratio;
    }

    @Override
    protected double convert(double src) {
        return src / ratio;
    }

    @Override
    protected String srcString() {
        return "원";
    }

    @Override
    protected String destString() {
        return "달러";
    }

    public static void main(String[] args) {
        week12_1 toDollar = new week12_1(1400); // 1달러는 1400원
        toDollar.run();
    }
}
