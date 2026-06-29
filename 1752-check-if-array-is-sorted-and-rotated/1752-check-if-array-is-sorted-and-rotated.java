class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n <= 1) return true;  // trivial case

        int dropCount = 0;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            if (nums[i] > nums[next]) {
                dropCount++;
                if (dropCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
