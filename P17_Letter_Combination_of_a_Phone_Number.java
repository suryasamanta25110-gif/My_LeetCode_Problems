import java.util.List;
import java.util.ArrayList;

public class P17_Letter_Combination_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {

        // Initializing variables and objects.
        List<String> combo = new ArrayList<>();
        String[] data = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "weyx"};

        // Calling function to find combinations.
        findCombinations(0, digits, data, new StringBuilder(), combo);

        // Returning the list of combinations.
        return combo;
    }

    // Recursive function to find the letter combinations.
    private void findCombinations(int index, String digits, String[] data, StringBuilder temp, List<String> combo) {

        // Base case.
        if (index == digits.length()) {
            combo.add(temp.toString());
            return;
        }

        // Finding the combinations.
        for (int i = 0; i < data[digits.charAt(index) - '2'].length(); i++) {
            temp.append(data[digits.charAt(index) - '2'].charAt(i));
            findCombinations(index + 1, digits, data, temp, combo);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
