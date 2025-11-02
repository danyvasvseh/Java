public class A {
    public final int a;

    // {
    //     a=11; // можно в блоке, но нельзя в конструкторе 
    // }
    public A(){ 
        this.a=11; // можно в конструкторе, но нельзя в блоке
    }
    public static void main(String[] args) {
        A a = new A();
    }
}
