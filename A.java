
public class A {

    public static void main(String[] args) {
        New smth = new New();
        smth.checkPassword("1234");
    }

}


class Old{
    @Deprecated // Указывает, что элемент устарел и не рекомендуется
    boolean checkPassword(String password){
        if (password == "1234") {
           return true;
        }
        return false;
    }
}

class New extends Old {

    @Override // Указывает, что метод переопределяет родительский метод
    @SuppressWarnings("deprecation") // Подавляет предупреждения (в данном случае
    //  использования устаревшего метода)
    boolean checkPassword(String password) {
        if (password.hashCode() == 509442) {
                return  super.checkPassword(password);
        }
        return false;
    }
}