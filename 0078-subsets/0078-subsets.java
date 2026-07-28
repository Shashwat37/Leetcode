class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void solve(int i, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));

        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            solve(j + 1, nums, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}