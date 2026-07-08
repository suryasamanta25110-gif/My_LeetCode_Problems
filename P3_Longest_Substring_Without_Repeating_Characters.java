public class P3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {

        // Initializing variables.
        int[] count = new int[256];
        int left = 0, right = 1, size = 0;

        // Counting the length of the largest possible substring.
        // (left, right] is our current substring.
        // We keep on checking whether the left is ahead of the character encountered or not.
        // We keep updating the last index of any character encountered.
        // If any character index is not zero, that means that character is repeated, or it appeared before.
        // We check left < that index in that case. If true, then we shift left to that index + 1.
        // In this way, we prevent repeated characters in our substring.
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
