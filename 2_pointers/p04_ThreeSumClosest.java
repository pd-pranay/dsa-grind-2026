import java.util.Arrays;

public class p04_ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
    }

    static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums); // sort first — required for two-pointer technique
        int dist = Integer.MAX_VALUE; // smallest difference found so far
        int closest = nums[0] + nums[1] + nums[2]; // best sum found so far (init with first triplet)

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1; // pointer right after i
            int right = nums.length - 1; // pointer at the end

            while (left < right) {
                /*
                 * Fix i, then move left/right toward each other (two-pointer).
                 * 
                 * currentSum = nums[i] + nums[left] + nums[right]
                 * difference = |target - currentSum|
                 * 
                 * Track the smallest difference seen -> update dist & closest.
                 * 
                 * Decide next move by comparing currentSum to target:
                 * currentSum == target -> exact match, return immediately
                 * currentSum < target -> sum too small, need bigger -> left++
                 * currentSum > target -> sum too big, need smaller -> right--
                 */

                int currentSum = nums[i] + nums[left] + nums[right];
                int difference = Math.abs(target - currentSum);

                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                // keep the closest sum seen so far
                if (difference < dist) {
                    dist = difference;
                    closest = currentSum;
                }

                // perfect match found, can't do better than 0 difference
                if (currentSum == target) {
                    return target;
                }

                // move pointers based on currentSum vs target (NOT difference vs target)
                if (currentSum < target) {
                    left++; // sum too small -> increase it
                } else if (currentSum > target) {
                    right--; // sum too big -> decrease it
                }

            }

        }

        return closest; // return the actual sum, not the distance
    }
}