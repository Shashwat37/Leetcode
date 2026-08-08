class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        solve(s, 0, cur, ans);

        return ans;
    }

    void solve(String s, int i, List<String> cur, List<List<String>> ans) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            int l = i;
            int r = j;
            boolean ok = true;

            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    ok = false;
                    break;
                }
                l++;
                r--;
            }

            if (ok) {
                cur.add(s.substring(i, j + 1));
                solve(s, j + 1, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }
}