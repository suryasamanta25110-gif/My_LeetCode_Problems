public class P3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {

        // Initializing variables.
        int[] count = new int[256];
        int left = 0, right = 1, size = 0;

        // Counting the length of the largest possible substring.
        while (right <= s.length()) {
            if (count[s.charAt(right - 1)] > 0)
                left = Math.max(left, count[s.charAt(right - 1)]);
            count[s.charAt(right - 1)] = right;
            right++;
            size = Math.max(size, right - left - 1);
        }

        // Returning the value.
        return size;
    }
}
