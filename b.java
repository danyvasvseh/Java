public class b {
        public static void main(String[] args) {
        Sub s = new Sub();// не пустит
        //s.fin();
    }
}

final class Supeer{
    void fin(){
        System.out.println("fin");
    }
}

class Sub extends Supeer{
    @Override
    void fin(){
        System.out.println("not fin");
    }
}
