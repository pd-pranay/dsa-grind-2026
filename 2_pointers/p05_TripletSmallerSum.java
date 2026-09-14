import java.util.Arrays;

public class p05_TripletSmallerSum {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 3, 4, 7 };
        int target = 12;
        System.out.println(threeSum(arr, target));
    }

    static int threeSum(int[] arr, int target) {
        // Step 1: Sort array to enable two-pointer strategy
        Arrays.sort(arr);
        int count = 0;

        // Step 2: Fix first element (stop at length - 2 to leave room for left & right)
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            // Step 3: Two-pointer check
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum < target) {
                    // KEY TRICK: Since array is sorted, EVERY element from
                    // (left + 1) up to `right` will also form a sum < target.
                    // since its sorted so r-1 is less than r;
                    // So add all these pairs at once!
                    count += (right - left);

                    left++; // This left has already made pair with the rights
                } else {
                    // Handles BOTH currentSum > target AND currentSum == target
                    right--; // Try a smaller sum
                }
            }
        }

        return count;
    }
}