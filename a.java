import java.util.Arrays;

public class a {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.print("Привет");               // → "Одна строка: Привет" (обычный метод)
        p.print("Привет", "Мир");       // → "Строки: [Привет, Мир]" (перегруженный метод)
        p.print(1, 2, 3);               // → "Числа: [1, 2, 3]" 
    }
}
public class Printer {
    // Varargs с типом String
    public void print(String... messages) {
        System.out.println("Строки: " + Arrays.toString(messages));
    }

    // Varargs с типом int
    public void print(int... numbers) {
        System.out.println("Числа: " + Arrays.toString(numbers));
    }

    // Обычный метод (не varargs)
    public void print(String message) {
        System.out.println("Одна строка: " + message);
    }
}