// не будем мудрить
class Ex1 extends Exception { }
class Ex2 extends Ex1 { }
class Ex3 extends Ex2 { }

public class A {
    public static void main(String[] args) {

        //1. Одинаковая обработка разных исключений
        try {
            // казино
            if (Math.random() > 0.5) {
                throw new java.io.IOException();
            } else {
                throw new NumberFormatException();
            }
        } catch (java.io.IOException | NumberFormatException e) {
            // логируем и завершаем операцию
            System.err.println("Обработано одинаково: " + e.getClass().getSimpleName() + " — " + e.getMessage());
        }

       // Обработка иерархии исключений
         try {
            // Генерируем исключение 3 уровня
            throw new Ex3();
        } catch (Ex3 e) {
            System.out.println("Обработано Ex3 (самый конкретный)");
        } catch (Ex2 e) {
            System.out.println("Обработано Ex2");
        } catch (Ex1 e) {
            System.out.println("Обработано Ex1 (самый общий)");
        }

       // Другой порядок выдаст ошибку, работает только от частного к общему
    }
}