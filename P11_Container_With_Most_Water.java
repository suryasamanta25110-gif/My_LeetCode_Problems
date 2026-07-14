public class P11_Container_With_Most_Water {
    public int maxArea(int[] height) {

        // Initializing variables.
        int left = 0, right = height.length - 1;
        int maxVolume = 0;

        // Finding the maximum possible volume of water in the container.
        while (left != right) {
            maxVolume = Math.max(Math.min(height[left], height[right]) * (right - left), maxVolume);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        // Returning the maximum volume.
        return maxVolume;
    }
}
