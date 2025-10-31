public class u {
    public static void main(String[] args) {
        double d = 123.9999999;
        i = (int) d;  // отбрасываем  
        float f = (float) d; // округляем
        System.out.println(i);
        System.out.println(f);

        int i = 300;
        byte b = (byte) i;  // 300 % 256 = 44 
        System.out.println(b); // Вывод: 44

        long l = 3_000_000_000L;
        i = (int) l; // long (64 бита) → int (32 бита)
        System.out.println(i); // Вывод: -1294967296
    }
}
