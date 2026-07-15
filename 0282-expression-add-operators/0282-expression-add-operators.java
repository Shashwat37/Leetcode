class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        dfs(num, target, 0, 0, 0, "");
        return ans;
    }

    private void dfs(String num, int target, int idx, long curr, long prev, String path) {

        if (idx == num.length()) {
            if (curr == target)
                ans.add(path);
            return;
        }

        long val = 0;

        for (int i = idx; i < num.length(); i++) {

            if (i > idx && num.charAt(idx) == '0')
                break;

            val = val * 10 + (num.charAt(i) - '0');

            String s = String.valueOf(val);

            if (idx == 0) {
                dfs(num, target, i + 1, val, val, s);
            } else {
                dfs(num, target, i + 1, curr + val, val, path + "+" + s);

                dfs(num, target, i + 1, curr - val, -val, path + "-" + s);

                dfs(num, target, i + 1,
                    curr - prev + prev * val,
                    prev * val,
                    path + "*" + s);
            }
        }
    }
}