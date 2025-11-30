import java.io.FileInputStream;
import java.io.IOException;

public class C {

    public static void main(String[] args) {
        // FileInputStream реализует Closeable, который реализует AutoCloseable
        try (FileInputStream fis = new FileInputStream("file.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            // fis.close() вызовется здесь сам
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        //ресурс закрыт - всё ок  
    }
}

