public class s {
    public static void main(String[] args) {
         byte x = 1;
        short y = 2;
        int res = x+y; /* "Любая операция с участием различных типов даст результат, 
        тип которого будет соответствовать большему из типов операндов." - неправда:
        в этом случае результат выдаст int. Так работает для int и всех меньших*/ 
       

        byte sum = (byte)(res); // можно так
        
        int a = 120;
        //byte b = a + 10;
        byte c = (byte)(a + 10);

        a = 5;
        int b = 2;
        double d = a / b; // сначала делим потом преобразуем
        System.out.println(d); // 2.0, а не 2.5 
        d = (double) a / b; // можно так
        System.out.println(d);

        long l = 1000L;
        long t = l+a; // a - int, но расширятся автоматически
        int i = (int) l+a; // а вот сужать надо руками
    }
}
