public class B {
    public static void main(String[] args) {
        String str = "Hello";
        // String в StringBuilder и в StringBuffer переводится конструктором
        StringBuilder sb = new StringBuilder(str);
        StringBuffer sbf = new StringBuffer(str);

        // StringBuilder и StringBuffer в String переводится методом toString()
        str = sb.toString();
        str = sbf.toString();

        // StringBuilder и StringBuffer переводятся друг в друга композицией

        sb = new StringBuilder(sbf.toString());
        sbf = new StringBuffer(sb.toString());

        // или можно просто положить друг друга в конструктор как CharSequence
        sb = new StringBuilder(sbf);
        sbf = new StringBuffer(sb);

    }
}
