package hello.core.singleton;

public class StatefulService {

    // 필드대신 자바에서 공유되지 않는 지역변슈, 파라미터, threadlocal 등을 사용
    // private int price; // 상태를 유지하는 빌드


    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
       //  this.price = price; //여기가 문제임!!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
