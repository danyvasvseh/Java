public class oper{
    public static void main(String[] args) {
        int a = 10;        // =
        a += 5;            // a = a + 5 → 15
        a -= 3;            // a = a - 3 → 12
        a *= 2;            // a = a * 2 → 24
        a /= 4;            // a = a / 4 → 6
        a %= 4;            // a = a % 4 → 2
        
        String s = "Привет";  
        s += ", мир!";        // конкатенация

        int x = 5;
        int abs = (x >= 0) ? x : -x; 

        boolean adult = (x >= 18) ? true : false;

        // С String:
        String result = (x > 0) ? "Positive" : "Non-positive";
        
        boolean c = true, d = false;
        boolean or = c || d;   // true
        boolean and = c && d;  // false


        a=5;
        x=3;
        int ior  = a | x;   // 0111 → 7
        int ixor = a ^ x;   // 0110 → 6
        int iand = a & x;   // 0001 → 1
        int not = ~a;       // 11111010

        int y = 10;
        x=5;
        boolean eq  = (x == y);  // false
        boolean gt  = (x > y);   // false
        boolean ge  = (x >= y);  // false
        boolean lt  = (x < y);   // true
        boolean le  = (x <= y);  // true

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        boolean eq1 = (s1 == s2);   // true 
        boolean eq2 = (s1 == s3);   // false (разные объекты)
       

        a = 8;  // 00001000

        int left   = a << 1;   // 00010000 → 16
        int right  = a >> 1;   // 00000100 → 4
        int rightU = a >>> 1;  // 00000100 → 4


        a = 10;
        int b = 3;
        int sum = a + b;   // 13
        int sub = a - b;   // 7
        int mul = a * b;   // 30
        int div = a / b;   // 3 
        int mod = a % b;   // 1

        s = "Result: " + 42;  // "Result: 42"


        a = 5;
        b = a++;  // постфикс: b = 5, a = 6
        int p = ++a;  // префикс: a = 7, c = 7

        int q = 5;
        int e = q--;  // постфикс: e = 5, d = 4
        int f = --q;  // префикс: d = 3, f = 3

        boolean flag = true;
        boolean notFlag = !flag;  // false
       
        int res = (2 + 2) * 2;  // 8
        
        char[] chars = "Hello".toCharArray();
        char ch = chars[1];  // 'e'

        int[] arr = {10, 20, 30};
        int val = arr[1];  // 20

        String[] words = {"Java", "is", "Java"};
        String word = words[0];  // "Java"
            
    }
        
}