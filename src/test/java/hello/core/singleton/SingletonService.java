package hello.core.singleton;

public class SingletonService {

    // 자기자신을 내부에 private static으로 가지고 있어, 클래스 레벨에 올라감
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
