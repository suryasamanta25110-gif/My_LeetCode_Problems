import java.util.HashMap;

public class P1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {

        // Initializing variables and objects.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Running loop to find the required indexes.
        // If the required pair of a number is not found in the map, the number is added in the map.
        // If found, then the index of the pairs is returned.
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }

        // Returning a default value if the required pair is not found.
        return new int[] {-1, -1};
    }
}
