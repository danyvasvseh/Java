public class A {
    public static void main(String[] args) {
         Class obj = new Class();

        // Вызов default-метода через экземпляр реализующего класса
        obj.defaultMethod(); 

        // Вызов статического метода интерфейса осуществляется только через имя интерфейса
        Interface.staticMethod(); 
    }
}

interface Interface {
    // Неабстрактный метод
    default void defaultMethod() {
        System.out.println("Это default-метод из интерфейса");
    }

    // Статический метод
    static void staticMethod() {
        System.out.println("Это статический метод из интерфейса");
    }

}

class Class implements Interface {

}

