import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class B {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        // Преобразуем в Date для совместимости со спецификаторами %t...
        Date currentDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        // Форматируем с использованием спецификаторов времени
        String formatted = String.format(
            "Текущее время:\n" +
            "  Часы (24-часовой формат): %tH\n" +  // ab
            "  Минуты: %tM\n" +                     // ab
            "  Секунды: %tS\n" +                    // ab
            "  Месяц: %tB\n" +                      // полное название месяца
            "  Год: %tY\n",                         // abcd
            currentDate, currentDate, currentDate, currentDate, currentDate
        );

        System.out.println(formatted);
    }
    
}
