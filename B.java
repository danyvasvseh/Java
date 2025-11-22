public class B {
    public static void main(String[] args) {
        Class class1 = new Class();
        class1.defaultMethod();
    }
}


interface One {
    // Неабстрактный метод
    default void defaultMethod() {
        System.out.println("Это default-метод из интерфейса 1");
    }

}

interface Two {
    // Неабстрактный метод
    default void defaultMethod() {
        System.out.println("Это default-метод из интерфейса 2");
    }

}



class Class implements One, Two { // без переопределения совпадающих методов 
    // будет ошибка компеляции, надо переопределять
    @Override
    public void defaultMethod() {
        One.super.defaultMethod();
    }

}
