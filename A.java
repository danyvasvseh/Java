
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class A {
    public static void main(String[] args) {
        // Исходная строка
        String text = "Java";

        // Преобразуем строку в массив байтов
        byte[] data = text.getBytes(); 

        // Создаём ByteArrayInputStream на основе массива
        ByteArrayInputStream bis = new ByteArrayInputStream(data);

        int byteValue;
       
        while ((byteValue = bis.read()) != -1) {
            char ch = (char) (byteValue+3); // преобразуем байт в символ
            System.out.print(ch); // шифр Цезаря? 
        }
       
    }
}

