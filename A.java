public class A { 
   
    public static void main(String[] args) {
        System.out.println("Начало программы");

        try {
            // Генерация первого исключения - ArithmeticException
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
            // Программа продолжает выполнение
        }

        System.out.println("После обработки ArithmeticException");

        // Генерация второго исключения - NullPointerException (без try-catch)
        String str = null;
        int length = str.length(); //  Эта строка вызовет аварийную остановку

        // Эта строка НИКОГДА не выполнится
        System.out.println("Это сообщение не появится");
    }

}
