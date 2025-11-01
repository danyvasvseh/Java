public class ator {
    public static void main(String[] args) {
        Object obj = "Привет";

        if (obj instanceof String s) {
            System.out.println("Длина строки: " + s.length());  // гарантия, что всё ок
        }

        Number d =3;
        // System.out.println(d instanceof String); // так нельзя
        // System.out.println(d instanceof Number); // и так тоже, 
        //т.к классы чисел не находятся в отношении родитель-потомок
        
        System.out.println(d instanceof Float);
        System.out.println(d instanceof Integer);
        String s = null; // null всегда false
        System.out.println(s instanceof String); // false
        System.out.println(s instanceof Object); // false
    }
}
