import java.util.List;
import java.util.stream.Stream;

public class SampleMain {
    public static void main(String[] args) {
        NestedClass c1 = new NestedClass("안녕", 1);
        NestedClass c3 = new NestedClass("진짜배기", 3);
        NestedClass c2 = new NestedClass("진짜배기3", 2);
        List<NestedClass> cList = List.of(c1, c3, c2);
        Stream<NestedClass> sorted = cList.stream().sorted((nc1, nc2) -> nc1.getId() - nc2.getId());
        sorted.forEach(System.out::println);
    }
    private static class NestedClass{
        public String getName() {
            return name;
        }
    
        public int getId() {
            return id;
        }
    
        public NestedClass(String name, int id) {
            this.name = name;
            this.id = id;
        }
    
        @Override
        public String toString() {
            return "NestedClass{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    
        private String name;
        private int id;
    }
}
