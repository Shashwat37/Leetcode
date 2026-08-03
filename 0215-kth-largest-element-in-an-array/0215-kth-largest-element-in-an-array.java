class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int l = 0;
        int r = nums.length - 1;
        Random rand = new Random();

        while (l <= r) {
            int p = nums[l + rand.nextInt(r - l + 1)];

            int i = l;
            int j = l;
            int t = r;

            while (j <= t) {
                if (nums[j] < p) {
                    int x = nums[i];
                    nums[i] = nums[j];
                    nums[j] = x;
                    i++;
                    j++;
                } else if (nums[j] > p) {
                    int x = nums[j];
                    nums[j] = nums[t];
                    nums[t] = x;
                    t--;
                } else {
                    j++;
                }
            }

            if (target < i) {
                r = i - 1;
            } else if (target > t) {
                l = t + 1;
            } else {
                return nums[target];
            }
        }

        return -1;
    }
}