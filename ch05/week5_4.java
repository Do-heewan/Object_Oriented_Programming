// 04 super() 사용과 이해

package ch05;

// 부모 클래스
class Parent {
    String name;

    // 부모 클래스 생성자
    public Parent(String name) {
        this.name = name;
        System.out.println("부모 클래스 생성자 호출: " + name);
    }

    public void display() {
        System.out.println("부모 클래스 display 메소드 호출: " + name);
    }
}

// 자식 클래스
class Child extends Parent {
    int age;

    // 자식 클래스 생성자
    public Child(String name, int age) {
        super(name);
        this.age = age;
        System.out.println("자식 클래스 생성자 호출: " + name + "," + age);
    }

    public void display() {
        super.display();
        System.out.println("자식 클래스 display 메소드 호출: " + name + "," + age);
    }
}

public class week5_4 {
    public static void main(String[] args) {
        Child child = new Child("홍길동", 25);
        child.display();
    }
}
