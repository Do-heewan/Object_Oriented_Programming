// 03 메소드 오버라이딩(기본)

package ch05;

// 동물 클래스
class Animal {
    void eat() {
        System.out.println("동물이 먹습니다.");
    }

    void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Cat extends Animal {
    void eat() {
        System.out.println("고양이가 생선을 먹습니다.");
    }

    void sound() {
        System.out.println("야옹~!");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("강아지가 사료를 먹습니다.");
    }

    void sound() {
        System.out.println("멍멍");
    }
}

public class week5_3 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println("=== 고양이 ===");
        cat.eat();
        cat.sound();

        Dog dog = new Dog();
        System.out.println("=== 강아지 ===");
        dog.eat();
        dog.sound();
    }
}
