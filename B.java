import java.util.StringJoiner;

public class B {
    public static void main(String[] args) {
    
        StringJoiner sj = new StringJoiner(", ");
        sj.add("яблоки");
        sj.add("апельсины");
        sj.add("бананы");
        
        System.out.println(sj); // яблоки, апельсины, бананы

        StringJoiner sj2 = new StringJoiner(", ", "[", "]");
        sj2.add("1");
        sj2.add("2");
        sj2.add("3");
        System.out.println(sj2); // [1, 2, 3]


        sj.merge(sj2);
        System.out.println(sj); // яблоки, апельсины, бананы, 1, 2, 3
            }


}