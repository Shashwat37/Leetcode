class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] freq = new int[100001];
        long sum = 0, best = 0;
        int distinct = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (freq[nums[i]] == 0) 
            distinct++;
            freq[nums[i]]++;

            if (i >= k) {
                int left = nums[i - k];
                sum -= left;
                freq[left]--;
                if (freq[left] == 0) distinct--;
            }

            if (distinct == k) {
                best = Math.max(best, sum);
            }
        }

        return best;
    }
}