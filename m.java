import java.util.Arrays;


public class m {
    public static void main(String[] args) {

        int[] arr = {20, 40, 10, 50, 30};
        
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int index = Arrays.binarySearch(arr, 30);
        System.out.println(index); // 2

        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};

        System.out.println(Arrays.equals(a1, a2));

        boolean[] a = {true, true};
        boolean[] b = {true, false};
        int r = Arrays.compare(a,b); //1
        }
}
