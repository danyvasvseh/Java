// самый используемый пример перегрузки - System.out.println(), который может принимать
// примитивы, строки, классы и пр.

public class a {
    public static void main(String[] args) {
        
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(1, 2));
        System.out.println(calculator.sum(1.0, 2.0));
        System.out.println(calculator.sum(new int[]{1, 2, 22}));
    }
}

class Calculator {
    
    public int sum(int a, int b) {
        return a + b;
    }


    // Перегрузка: разные типы параметров
    public double sum(double a, double b) {
        return a + b;
    }

    // Перегрузка: массивы
    public int sum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

   
}