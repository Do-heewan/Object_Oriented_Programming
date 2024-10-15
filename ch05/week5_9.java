// 09 상속

package ch05;

class Buyer {
    int money = 1000;
    Product cart[] = new Product[3]; // 구입한 제품을 저장하기 위한 배열
    int i = 0; // Product cart index 배열에 사용함

    void buy(Product p) {
        // 1.1 가진 돈과 물건의 가격을 비교하여 가진 돈이 적으면 메서드 종료.
        if (money < p.price) {
            System.out.println("잔액이 부족하여" + p + "을/를 살 수 없습니다.");
            return;
        }
        // 1.2 가진 돈이 충분하다면 제품의 가격을 가진 돈에서 빼고
        else {
            money = money - p.price;
        }
        // 1.3 장바구니에 구입한 물건을 담는다. (add 메서드 호출)
        add(p);
    }

    void add(Product p) {
        // 1.1 i의 값이 장바구니의 크기보다 같거나 크면
        if (i >= cart.length) {
            // 1.1.1 기존의 장바구니 보다 2배 큰 새로운 배열 사용
            Product new_cart[] = new Product[cart.length * 2];
            // 1.1.2 기존의 장바구니의 내용을 새로운 배열에 복사한다.
            // new_cart[] = cart.clone();                                         // clone()은 왜 안될까? -> 배열 복제와는 다르게 arraycopy는 부분 복사이기 때문
            System.arraycopy(cart, 0, new_cart, 0, cart.length); 
            // 1.1.3 새로운 장바구니와 기존의 장바구니를 바꾼다.
            cart = new_cart;
        }

        // 1.2 물건을 장바구니(cart)에 저장한다. 그리고 i의 값을 1 증가시킨다.
        cart[i] = p;
        i += 1;
    }

    void summary() {
        String shopList = "";
        int sum = 0; 
        for (int j = 0; j < cart.length; j++) {
            // cart는 3의 배수만큼 크기가 증가한다. 결국 입력의 갯수에 따라 끝 부분에는 배열의 빈 공간이 생길 수 있기 때문에 break를 해준다.
            if (cart[j] == null) {
                break;
            }
            // 1.1 장바구니에 담긴 물건들의 목록을 만들어 출력한다.
            shopList += cart[j] + ",";
            // 1.2 장바구니에 담긴 물건들의 가격을 모두 더하여 출력한다.
            sum += cart[j].price;
        }
        // 1.3 물건을 사고 남은 금액을 출력한다.
        System.out.println("구입한 물건 : " + shopList);
        System.out.println("사용한 금액 : " + sum);
        System.out.println("남은 금액 : " + money);
    }
}

class Product {
    int price;

    Product (int price) {
        this.price = price;
    }
}

class SmartTv extends Product {
    SmartTv() {
        super(100);
    }

    public String toString() {
        return "SmartTv";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    public String toString() {
        return "Computer";
    }
}

class Audio extends Product {
    Audio() {
        super(50);
    }

    public String toString() {
        return "Audio";
    }
}

public class week5_9 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        b.buy(new SmartTv());
        b.buy(new Computer());
        b.buy(new SmartTv());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());

        b.summary();
    }
}
