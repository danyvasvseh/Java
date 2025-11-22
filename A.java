public class A {
    public static void main(String[] args) {
        String text = "  Hello, World!  ";
        String name = "java";
        String sentence = "apple,banana,orange";
        String empty = "";
        String mixed = "Java123";

        // 1. length() — возвращает длину строки (количество символов)
        System.out.println("1. Длина строки \"" + text + "\": " + text.length());

        // 2. trim() — удаляет пробелы в начале и конце строки
        String trimmed = text.trim();
        System.out.println("2. После trim(): \"" + trimmed + "\"");

        // 3. toUpperCase() — преобразует строку в верхний регистр
        System.out.println("3. В верхнем регистре: " + name.toUpperCase());

        // 4. toLowerCase() — преобразует строку в нижний регистр
        System.out.println("4. В нижнем регистре: " + name.toLowerCase());

        // 5. equalsIgnoreCase() — сравнивает строки без учёта регистра
        System.out.println("5. \"JAVA\".equalsIgnoreCase(\"java\") → " 
                          + "JAVA".equalsIgnoreCase("java"));

        // 6. startsWith() — проверяет, начинается ли строка с указанного префикса
        System.out.println("6. Строка \"" + name + "\" начинается с 'ja'? " 
                          + name.startsWith("ja"));

        // 7. endsWith() — проверяет, заканчивается ли строка указанным суффиксом
        System.out.println("7. Строка \"" + text + "\" заканчивается на '!'? " 
                          + text.endsWith("!"));

        // 8. split() — разбивает строку на массив подстрок по разделителю
        String[] fruits = sentence.split(",");
        System.out.print("8. Разделённая строка \"apple,banana,orange\": ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 9. isEmpty() — проверяет, является ли строка пустой (длина 0)
        System.out.println("9. Строка \"" + empty + "\" пуста? " + empty.isEmpty());
        System.out.println("   Строка \"x\" пуста? " + "x".isEmpty());

        // 10. replace() — заменяет все вхождения подстроки на другую
        String cleaned = mixed.replace("123", " is awesome");
        System.out.println("10. Замена '123' на ' is awesome': " + cleaned);

    }
}

