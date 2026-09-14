import java.util.Arrays;

public class p08RemoveDuplicateSortedArray02 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        solution sol = new solution();
        int k = sol.removeDuplicates(nums);
        System.out.println("k: " + k);
        System.out.println(Arrays.toString(nums));
    }

    private static class solution {
        public int removeDuplicates(int[] nums) {
            System.out.println("hey");
            // right scans the array
            // left writes the kept values to the front
            // Recall: right explores new numbers, left writes the final kept ones.
            // Keep at most 2 copies of any value: count > 2 means skip, else copy forward.

            int left = 1, right = 1, count = 1;
            while (right < nums.length) {
                if (nums[right] == nums[right - 1]) {
                    count++; // increase the count if same element as prev
                } else {
                    count = 1; // new element reset the count
                }

                // left job is to point at the swapable index value with right
                // left keeps the valid (required values) values at the front
                if (count <= 2) {
                    // keep the valid value in front (“Front” means the beginning of the array.)
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }

            return left;
        }
    }
}

// means move the left max 2
// and point to next swap able item
// goal is to point left to swapable item