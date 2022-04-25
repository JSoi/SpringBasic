package singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    // 자기 자신을 내부에 private static으로 선언해서 클래스 레벨에 올라가 하나만 생성된다.

    public static SingletonService getInstance() { // 조회할 때 사용
        // 외부에서 접근할 때 유일하게 인스턴스를 조회할 수 있는 방법
        // 내부적으로 생성해서 instance를 참조시킨다.
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 로직 생성");
    }

}
