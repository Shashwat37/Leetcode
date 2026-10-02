import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] a = s.toCharArray();

        solve(a, 0, ans);

        return ans;
    }

    public void solve(char[] a, int i, List<String> ans) {
        if (i == a.length) {
            ans.add(new String(a));
            return;
        }

        if (Character.isDigit(a[i])) {
            solve(a, i + 1, ans);
            return;
        }

        a[i] = Character.toLowerCase(a[i]);
        solve(a, i + 1, ans);

        a[i] = Character.toUpperCase(a[i]);
        solve(a, i + 1, ans);
    }
}