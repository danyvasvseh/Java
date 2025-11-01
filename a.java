public class a {

    public static void main(String[] args) {

    char grade = 'A'; // + класс
    switch (grade) {
        case 'A': System.out.println("Отлично"); break;
        case 'B': System.out.println("Хорошо"); break;
    }

    int i = 2; // и любой до int: byte, shotr + класс
    switch (i) {
        case 1: System.out.println("Один"); break;
        case 2: System.out.println("Два"); break;
    }
    

    String day = "воскресенье";
    switch (day) {
        case "понедельник": System.out.println("Не выходной..."); break;
        case "воскресенье": System.out.println("Выходной!"); break;
    }


    enum Color { RED, GREEN, BLUE }

    Color c = Color.GREEN;
    switch (c) {
        case RED: System.out.println("Красный"); break;
        case GREEN: System.out.println("Зелёный"); break;
        case BLUE: System.out.println("Синий"); break;
    }
    
    }
    
    
}
