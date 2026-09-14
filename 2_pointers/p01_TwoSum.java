import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p01_TwoSum {

    public static void main(String[] args) {
        int[] ans = twoSum(new int[] { 2, 11, 33, 7 }, 9);
        String s = Arrays.toString(ans);
        System.out.println("Hello World" + s);
        System.out.println("-------------------");
        ans = twoSumSorted(new int[] { -1, 0 }, -1);
        s = Arrays.toString(ans);
        System.out.println("Hello World" + s);
    }

    // * * HACK: Question says return the index, then dont sort.
    static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        // Array to store the Indexes
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) { // Find the reaminder exists in the map
                arrayList.add(map.get(rem)); // If found get the rem(old) & the current value and return
                arrayList.add(i);
            }
            map.put(nums[i], i);
        }

        return arrayList
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // question sorted array,
    // Let these two numbers be numbers[index1] and numbers[index2]
    // where 1 <= index1 < index2 <= numbers.length.
    // ! Returned Index should start at 1.
    static int[] twoSumSorted(int[] numbers, int target) {
        int[] ans = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                return ans;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

}
