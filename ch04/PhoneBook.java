// 06 객체 배열(2)

package ch04;

import java.util.Scanner;

class Phone {
    private String name;
    private String tel;

    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }
    
    public String getTel() {
        return tel;
    }
}

public class PhoneBook {
    Scanner scanner;
    Phone phone [];

    public PhoneBook() {
        scanner = new Scanner(System.in);
    }

    public void read() {
        System.out.println("연락처를 저장할 인원수를 입력하시오. : ");
        int p = scanner.nextInt();
        phone = new Phone[p];

        for (int i = 0; i < p; i++) {
            System.out.print("이름과 전화번호 (이름과 번호는 빈 칸 없이 입력) : ");
            String name = scanner.next();
            String tel = scanner.next();

            phone[i] = new Phone(name, tel);
        }
        System.out.print("저장되었습니다...\n");
    }

    public String search(String name) {
        for (int i = 0; i <phone.length; i++) {
            if (name.equals(phone[i].getName())) {
                return phone[i].getTel();
            }
        }
        return null;
    }

    public void run() {
        read();

        while (true) {
            System.out.println("검색 할 이름을 입력해주세요. : ");
            String searchName = scanner.next();
            String tel = search(searchName);
            if (searchName.equals("Exit")) {
                break;
            }
            if (tel == null) {
                System.out.printf("%s 이(가) 없습니다.\n", searchName);
            }
            else {
                System.out.printf("%s의 번호는 %s입니다.\n", searchName, tel);
            }
        }
    }

    public static void main(String[] args) {
        new PhoneBook().run();
    }
}
