import java.util.*;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };

        HashSet<String> set = new HashSet<>();

        for (String s : words) {
            StringBuilder ans = new StringBuilder();

            for (char c : s.toCharArray()) {
                ans.append(code[c - 'a']);
            }

            set.add(ans.toString());
        }

        return set.size();
    }
}