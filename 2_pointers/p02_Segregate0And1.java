import java.util.Arrays;

public class p02_Segregate0And1 {
    public static void main(String[] args) {
        int[] numbers = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
        // int[] numbers = {1,1};

        int[] sorted = segerate(numbers);
        String ans = Arrays.toString(sorted);
        System.out.println(ans);
    }

    static int[] segerate(int[] arr) {

        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            if (arr[l] == 0) {
                l++;
            } else if (arr[r] == 1) {
                r--;
            } else {
                arr[l] = 0;
                arr[r] = 1;
            }
        }

        return arr;
    }
}
