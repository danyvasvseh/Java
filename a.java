public class a {
    public static void main(String[] args) {
        Interface.NestedClass nested = new Interface.NestedClass("nothing");
        nested.show();
    }
}
interface Interface {
    // Вложенный класс внутри интерфейса
    class NestedClass {
        private String data;

        public NestedClass(String data) {
            this.data = data;
        }

        public void show() {
            System.out.println("Data: " + data);
        }

    }
}