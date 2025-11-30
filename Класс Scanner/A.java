import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        String filename = "data.txt"; // имя файла в той же папке
         String keyword = "Пьер";        // искомое слово (регистронезависимо)
        try (Scanner scanner = new Scanner(new File(filename))) {
            System.out.println("Содержимое файла:");

            // Пока есть следующая строка — читаем её
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                 // Проверяем, содержится ли слово в строке (игнорируя регистр)
                if (line.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: файл \"" + filename + "\" не найден.");
        }
    }
}