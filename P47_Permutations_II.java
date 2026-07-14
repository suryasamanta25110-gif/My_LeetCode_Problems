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
