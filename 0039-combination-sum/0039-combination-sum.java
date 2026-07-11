class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int i, int[] arr, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (i == arr.length || target < 0) {
            return;
        }

        curr.add(arr[i]);
        solve(i, arr, target - arr[i], curr, ans);
        curr.remove(curr.size() - 1);

        solve(i + 1, arr, target, curr, ans);
    }
}