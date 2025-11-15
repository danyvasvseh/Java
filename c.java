public class c {
    public static void main(String[] args) {
        Wrong wrong =new Wrong();
        wrong.gotName(); // не скомпилируется
        wrong.getName(2); // и это тоже
    }
}

class Base {
    public Base getName() {
        return this;
    }
}

class Wrong extends Base {
    @Override
    public Base gotName() { // @Override выявил ошибку в названии
        return this;
    }

    @Override
    public Base getName(int a) { // @Override выявил ошибку в аргументах
        return this;
    }
}


