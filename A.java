public class A {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        // 1. append() — добавляет строку (или другой тип) в конец
        sb.append(" World");
        System.out.println("1. append(): " + sb); // Hello World

        // 2. insert() — вставляет строку в указанную позицию
        sb.insert(5, ","); // Вставляем запятую перед пробелом
        System.out.println("2. insert(): " + sb); // Hello, World

        // 3. delete() — удаляет символы в диапазоне [start, end)
        sb.delete(5, 6); // Удаляем запятую (позиция 5)
        System.out.println("3. delete(): " + sb); // Hello World

        // 4. deleteCharAt() — удаляет символ по индексу
        sb.deleteCharAt(5); // Удаляем пробел (индекс 5)
        System.out.println("4. deleteCharAt(): " + sb); // HelloWorld

        // 5. replace() — заменяет подстроку в диапазоне [start, end) на новую
        sb.replace(5, 10, " Java"); // Заменяем "World" на " Java"
        System.out.println("5. replace(): " + sb); // Hello Java

        // 6. reverse() — разворачивает строку задом наперёд
        sb.reverse();
        System.out.println("6. reverse(): " + sb); // avaJ olleH

        // 7. setCharAt() — заменяет символ по указанному индексу
        sb.setCharAt(0, 'J'); // Меняем первую букву на 'J'
        System.out.println("7. setCharAt(): " + sb); // JvaJ olleH

        // 8. length() — возвращает текущую длину строки
        System.out.println("8. length(): " + sb.length()); // 10

        // 9. capacity() — возвращает текущую ёмкость буфера (внутреннего массива)
        System.out.println("9. capacity(): " + sb.capacity()); // обычно 16 + дополнение

        // 10. toString() — преобразует StringBuilder в неизменяемую строку String
        String result = sb.toString();
        System.out.println("10. toString(): " + result);

    }

}
