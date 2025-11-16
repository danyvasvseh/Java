public class b {
    public static void main(String[] args) {
        Base base = new Base(7);
        Base.PublicInner publicInner = base.new PublicInner();
        // внутренний класс имеет доступ ко всем переменным класса
        // вне зависимости от их спецификатора
        // таким образом можно "расприватить" переменную
        System.out.println(publicInner.y); 
    }
}

class Base {
    private int x = 0;
    Base(int x){
        this.x = x;
    }

    public class PublicInner {
        PublicInner(){
            x=2;
            this.y = x;
        }
        public int y = 0;
    }

}
