public class A {
     public static void main(String[] args) {
        try {
            int result = 10 / 0; // Деление на ноль → ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
            // Вывод: / by zero
        }
        int[] arr = {1, 2, 3};
        try {
            int value = arr[5]; // Индекс 5 не существует (макс. — 2)
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
            // Вывод: Index 5 out of bounds for length 3
        }
        	
        
        try {
            setAge(-5); // Некорректный аргумент
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            // Вывод: Возраст должен быть от 0 до 150
        }
        
     
        Object obj = "Привет"; // obj ссылается на String
        try {
            // Попытка привести String к Integer — невозможно
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("Ошибка: " + e.getMessage());
            // Вывод: java.lang.String cannot be cast to java.lang.Integer
        }

         String str = null;
        try {
            int length = str.length(); // Вызов метода у null → NPE
        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e.getMessage());
            // Вывод: null (или просто stack trace, сообщение может быть null)
        }
    
    }
        public static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Возраст должен быть от 0 до 150");
        }
        System.out.println("Возраст установлен: " + age);


        }

}
