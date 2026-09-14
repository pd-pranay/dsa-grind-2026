import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p03_ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    // sum of 3 elements to 0
    static List<List<Integer>> threeSum(int[] nums) {
        // **
        // ** Sorting makes the comparison easy and the pointer can be started form the
        // edges.
        // ** Sorting is only valid when the quest ask to return the number not the
        // index.
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // ** -2 is because, for the end of iteration ie i, the left and right pointer
        // ** will point to one one element
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            /*
             * Required : nums[i] + nums[left] + nums[right] = 0
             * Find: - nums[i] = nums[left] + nums[right]
             */
            if (nums[i] > 0)
                break;
            int target = -nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));

                    // Skip duplicates for left and right pointers
                    // left<right since pointers cant cross each other
                    // keep doing until the same elements are removed
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

/*
 * https://leetcode.com/problems/3sum/description/
 * question
 * why the duplicate is skipped?
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 */