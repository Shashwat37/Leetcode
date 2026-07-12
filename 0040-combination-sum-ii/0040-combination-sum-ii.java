import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int idx, int target, int[] arr, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;

            list.add(arr[i]);
            solve(i + 1, target - arr[i], arr, list, ans);
            list.remove(list.size() - 1)
        }
    }
}