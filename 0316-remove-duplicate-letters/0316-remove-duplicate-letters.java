class Solution {
    public String removeDuplicateLetters(String s) {
        int[] f = new int[26];
        boolean[] used = new boolean[26];

        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            int x = c - 'a';
            f[x]--;

            if (used[x]) {
                continue;
            }

            while (ans.length() > 0 &&
                   ans.charAt(ans.length() - 1) > c &&
                   f[ans.charAt(ans.length() - 1) - 'a'] > 0) {

                used[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }

            ans.append(c);
            used[x] = true;
        }

        return ans.toString();
    }
}