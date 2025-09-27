// Ввод строки из консоли
import java.util.Scanner;

// Требуется обработка исключительной ситуации
public class cons {
    public static void main(String[] args) {
        System.out.println("Введите имя:");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        // Печать данных в консоли
        System.out.println("Привет, "+ name);
        }
}