public class b {
    public static void main(String[] args) {
        Wrong wrong = new Wrong();
        Correct correct = new Correct();
        System.out.println(correct.getName());
        System.out.println(wrong.getName()); // ошибка 
    }
}

class Base {
    public Base getName() {
        return this;
    }
}

class Wrong extends Base {
    public String getName() { // нельзя переоопределить на вообще любой тип
        return "Wrong";
    }
}

class Correct extends Base {
    public Correct getName() { // но можно переопределить на подтим
        return this;
    }
}