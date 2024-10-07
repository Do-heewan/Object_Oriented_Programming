// 08 Call by Reference

package ch04;

import java.util.Scanner;

public class week4_8 {
    static class Person {
        String name;
        public Person(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    }

    public static void changeName(Person p, String inputName) {
        p.setName(inputName);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Person p = new Person("John");

        System.out.println("Original Name : " + p.getName());

        System.out.println("새 이름을 입력하시오.");
        String inputName = s.nextLine();
        changeName(p, inputName);

        System.out.println("Modified name : " + p.getName());

        s.close();
    }
}
