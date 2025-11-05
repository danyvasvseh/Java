import java.util.ArrayList;
import java.util.List;

public class a {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        if (strings instanceof ArrayList) { // из-за стирания типов
            System.out.println("Это ArrayList!");
        }


        if (strings instanceof List<?> list) {
            // list сразу получит тип тип List<?>
            System.out.println("Размер: " + list.size());
        }

    }
}
