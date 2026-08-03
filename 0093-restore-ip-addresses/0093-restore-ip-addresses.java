class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(s, 0, 0, "", ans);
        return ans;
    }

    private void solve(String s, int i, int p, String cur, List<String> ans) {
        if (p == 4) {
            if (i == s.length()) {
                ans.add(cur.substring(0, cur.length() - 1));
            }
            return;
        }

        for (int j = 1; j <= 3 && i + j <= s.length(); j++) {
            String x = s.substring(i, i + j);

            if ((x.length() > 1 && x.charAt(0) == '0') || Integer.parseInt(x) > 255) {
                continue;
            }

            solve(s, i + j, p + 1, cur + x + ".", ans);
        }
    }
}