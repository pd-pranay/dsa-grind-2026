import java.util.Arrays;

public class p09_SquaresfSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] { -4, -1, 0, 3, 10 };

        solution sol = new solution();
        int[] ans = sol.sortedSquares(nums);
        System.out.println("Array: " + Arrays.toString(ans));

    }

    // bigger absolute value goes to the back of the answer
    // left is negative side, right is positive side, so fill the new array from the end
    private static class solution {
        public int[] sortedSquares(int[] nums) {
            int[] arr = new int[nums.length];

            // sorted so at edges edges
            int left = 0,
                    right = nums.length - 1,
                    index = nums.length - 1; // index for new array

            while (left <= right) {
                // find the greater elemnt and put it to the right
                // why: since the array is negative at left and positive at right also sorted
                // so abs of negative at the leftest would be the greater value and right would
                // be the greater values
                // comparing them would give you answe and
                // add the answer to the rightest of the new array
                if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                    arr[index] = nums[right] * nums[right];
                    index--;
                    right--;
                } else {
                    arr[index] = nums[left] * nums[left];
                    index--;
                    left++;
                }
            }

            return arr;
        }
    }
}
