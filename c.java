public class c {
    public static void main(String[] args) {
        Base base = new Base(7);
        Base.PrivateInner privateInner = base.new PrivateInner();
        // внешний класс имеет доступ ко всем переменным внутреннкго класса
        // вне зависимости от их спецификатора
        // таким образом можно "расприватить" переменную
        System.out.println(base.get_y()); 
    }
}

class Base {
    public int x = 0;
    private PrivateInner inner = new PrivateInner();
    
    Base(int x){
        inner.y = x;
        this.x = x;
    }

    public int get_y(){
        return inner.y;
    }

    public class PrivateInner {
        PublicInner(){
            x=2;
            this.y = x;
        }
        private int y = 0;
    }

}
