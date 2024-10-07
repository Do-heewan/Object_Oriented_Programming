// 01 간단한 클래스 생성

package ch04;

import java.util.Scanner;

public class Grade {
    private double oriented;
    private double ai;
    private double algorithm;

    public Grade(double oriented, double ai, double algorithm) {
        this.oriented = oriented;
        this.ai = ai;
        this.algorithm = algorithm;
    }

    public double average() {
        return (oriented + ai + algorithm) / 3;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("객체지향, 인공지능, 알고리즘 순으로 3개의 학점 입력 >> ");

        double oriented = s.nextDouble();
        double ai = s.nextDouble();
        double algorithm = s.nextDouble();
        
        Grade me = new Grade(oriented, ai, algorithm);
        System.out.printf("평균은 %.2f", me.average());

        s.close();
    }
}
