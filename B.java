import java.io.ByteArrayOutputStream;


public class B {
  
    public static void main(String[] args) {
      
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        bos.write(72);  // 'H'
        bos.write(101); // 'e'
        bos.write(108); // 'l'
        bos.write(108); // 'l'
        bos.write(111); // 'o'

        String result = bos.toString();
        System.out.println(result); // Hello
        
    }
}

