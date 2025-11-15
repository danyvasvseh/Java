
public class a {
        public static void main(String[] args) {
        Sub s = new Sub(0);
        s.fin();
    }
}

class Super{
    void fin(){
        System.out.println("fin");
    }

    int fun;

    public Super(int fun){
        this.fun = fun;
    }
}

class Sub extends Super{
    int fun;
    public Sub(int fun){
        super(fun-1); // обращения к конструктору суперкласса
        this.fun=super.fun; // доступу к полю суперкласса
    }
    @Override
    void fin(){
        super.fin(); //доступу к методу суперкласса
        System.out.println("not");
    }
}
