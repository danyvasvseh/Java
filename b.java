import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class b {

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        // калька с Collections.copy() - хороший пример
        // extends - все типы - T и наследники - хотя бы T - используется для чтения,
        // так как гарантирует, что читаем нужные типы
        // super - все типы - T и его предки - не более T - используется для записи
        // так как гарантирует, что пишем правильные типы
        // Проверяем, что оба списка не null
        if (dest == null || src == null) {
            throw new NullPointerException();
        }
        
        // Проверяем, что в dest достаточно места
        if (dest.size() < src.size()) {
            throw new IndexOutOfBoundsException(
                "Destination list is smaller than source list"
            );
        }
        
        // Копируем поэлементно
        for (int i = 0; i < src.size(); i++) {
            dest.set(i, src.get(i)); // 
        }
}
    public static void main(String[] args) {
        List<Integer> src = Arrays.asList(10, 20);
        List<Number> dest = new ArrayList<>(Arrays.asList(0.0, 0.0));

        b.copy(src, dest);
       
    }
}
