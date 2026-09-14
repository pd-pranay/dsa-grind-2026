import java.util.Arrays;

public class p07_RemoveDuplicateSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        solution sol = new solution();
        int k = sol.removeDuplicates(nums);
        System.out.println("k: " + k);
        System.out.println(Arrays.toString(nums));
    }

    private static class solution {
        public int removeDuplicates(int[] nums) {
            // 0,0,1,1,1,2,2,3,3,4

            int left = 1;
            int right = 1;

            while (right < nums.length) {
                // right to scan and left to point a index that need switch (that contains the
                // duplicate element)
                if (nums[right] != nums[right - 1]) {
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }

            return left;
        }
    }
}
