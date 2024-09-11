package ch02;

import java.util.Scanner;

public class exam1_3 {
    public static void main(String args[]) {
        double height, m_height, weight, BMI;

        Scanner s = new Scanner(System.in);
        System.out.println("몸무게를 입력하시오.(kg)");
        weight = s.nextDouble();

        System.out.println("키를 입력하시오.(cm)");
        height = s.nextDouble();

        m_height = (height / 100);
        BMI = weight / (m_height * m_height);
        
        if (BMI < 19)
            System.out.printf("BMI 지수 : %.2f, 판정결과 : 저체중", BMI);
        else if (BMI < 23)
            System.out.printf("BMI 지수 : %.2f, 판정결과 : 정상", BMI);
        else if (BMI < 29)
            System.out.printf("BMI 지수 : %.2f, 판정결과 : 과체중", BMI);
        else
            System.out.printf("BMI 지수 : %.2f, 판정결과 : 비만", BMI);
        
        s.close();
    }
}
