public class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }


    public static void main(String[] args) {
      A.printVars(); // через класс
      A a =new A();
      a.printVars(); // через экземпляр
      printVars();  // без ничего внутри класса
     }
}

