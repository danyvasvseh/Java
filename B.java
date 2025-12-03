import a.Public;

public class B {
    Public public1 = new Public();
    //int b = public1.pro;  - не выйдет
    //int c = public1.pac;  - не выйдет
    int d = public1.pub;
}

class C extends Public{
    int b = pro; // но в наследнике можно
    //int c = pac;  - не выйдет 
    int d = pub;
}