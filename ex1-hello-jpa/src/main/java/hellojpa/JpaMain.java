import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("hello");
        // hello는 /META_INF/persistence.xml의 <persistence-unit name="hello">의 name

    }
}
