import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class P47_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {

        // Initializing variables and objects.
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        // Sorting the given array.
        Arrays.sort(nums);

        // Calling the function to find the list of unique permutations.
        findPermutations(0, nums, used, new ArrayList<>(), permutations);

        // Returning the list.
        return permutations;
    }

    // Recursive function to find the list of unique permutations.
    private void findPermutations(int count, int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> permutations) {

        // Base case.
        if (count == nums.length) {
            permutations.add(new ArrayList<>(list));
            return;
        }

        // Finding the list of unique permutations.
        // We ignore the case when we encounter the element which is similar to another element and not being used.
        // For example, for input [1, 1, 2], in the first case, nums[0] is being used. So nums[1] is also being used.
        // In the second case, nums[0] is no more used, and nums[0] == nums[1]. So we skip this.
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            list.add(nums[i]);
            used[i] = true;
            findPermutations(count + 1, nums, used, list, permutations);
            list.removeLast();
            used[i] = false;
        }
    }
}
