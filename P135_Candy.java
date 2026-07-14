import java.util.Arrays;

public class P135_Candy {
    public int candy(int[] ratings) {

        // Initializing variables.
        int[] candies = new int[ratings.length];
        int total = 0;

        // Giving one candy to each child.
        Arrays.fill(candies, 1);

        // Traversing from the left-hand side.
        // Giving more candies to children having higher rating.
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] < ratings[i - 1])
                candies[i] = candies[i - 1] + 1;

        // Traversing from the right-hand side.
        // Giving more candies to children having higher rating.
        for (int i = ratings.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);

        // Finding the total number of candies given.
        for (int i : candies)
            total += i;

        // Returning the value.
        return total;
    }
}
