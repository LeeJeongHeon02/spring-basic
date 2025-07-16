package hello.core.singleton;

public class SingletonService {

    private static final SingletonService INSTANCE = new SingletonService();

    // private 생성자, 외부에서 객체를 생성하지 못하게 함.
    private SingletonService() {}

    public static SingletonService getInstance() {
        return INSTANCE;
    }


}
