public class a {
    public static void main(String[] args) {
        Super s = new Sub();// не пустит
        s.fin();
    }
}

class Super{
    final void fin(){
        System.out.println("fin");
    }
}

class Sub extends Super{
    @Override
    void fin(){
        System.out.println("not fin");
    }
}