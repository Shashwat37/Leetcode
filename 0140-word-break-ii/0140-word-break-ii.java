class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> dp = new HashMap<>();

        return solve(s, 0, set, dp);
    }

    private List<String> solve(String s, int i, Set<String> set,
                               Map<Integer, List<String>> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        List<String> ans = new ArrayList<>();

        if (i == s.length()) {
            ans.add("");
            return ans;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String word = s.substring(i, j);

            if (!set.contains(word)) {
                continue;
            }

            List<String> next = solve(s, j, set, dp);

            for (String x : next) {
                if (x.length() == 0) {
                    ans.add(word);
                } else {
                    ans.add(word + " " + x);
                }
            }
        }

        dp.put(i, ans);
        return ans;
    }
}