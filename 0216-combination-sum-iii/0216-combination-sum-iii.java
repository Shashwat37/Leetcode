class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(1, k, n, new ArrayList<>());
        return ans;
    }

    private void solve(int start, int k, int n, List<Integer> list) {
        if (k == 0) {
            if (n == 0) ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > n) break;
            list.add(i);
            solve(i + 1, k - 1, n - i, list);
            list.remove(list.size() - 1);
        }
    }
}