import java.util.Arrays;

public class p06_RemoveElement {
    public static void main(String[] args) {
        solution2 sol = new solution2();
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int k = sol.removeElement(nums, 2);
        System.out.println("k : " + k);
        System.out.println(Arrays.toString(nums));
    }

    // Recall: right scans every element; left marks the next position for a value
    // to keep.
    // Keep non-matching values at left, then return left as the new length.
    private static class solution2 {
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = 0;

            while (right < nums.length) {
                if (nums[right] != val) { // if the value is not same then switch
                    // else leave left at the point to swap with and right moves ahead
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }
            return left;
        }
    }

    private static class solution {
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                if (nums[left] == val) {
                    nums[left] = nums[right];
                    right--;
                } else {
                    left++;
                }
            }
            return right + 1;
        }
    }
}
