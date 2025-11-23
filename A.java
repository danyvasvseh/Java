public class A {

    public static void main(String[] args) {
        boolean flag = true;
        int number = 42;
        double pi = 3.14159;
        String name = "Алиса";

        // Используем метод String.format() для форматирования строки
        String result = String.format(
            "Флаг: %b%n" +             // %b — логическое значение
            "Число: %d%n" +            // %d — десятичное целое
            "Пи: %.2f%n" +             // %f — число с плавающей точкой (с ограничением до 2 знаков)
            "Имя: %s%n"+               // %s — строковое представление
            "%% - это символ процента%n",
            flag, number, pi, name     // аргументы подставляются по порядку
        );

        System.out.print(result);

    }
}


