package singleton;

public class StatefulService {
//    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        //주문할 때  가격 저장하는 메서드
        System.out.println("name = " + name + " price : " + price);
        return price;
    }

}
