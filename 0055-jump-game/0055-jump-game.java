class Solution {
    public boolean canJump(int[] nums) {
        int maxr = 0;
        for (int i = 0; i < nums.length; i++) 
        {
            if (i > maxr) 
            return false;
            maxr = Math.max(maxr, i + nums[i]);
            if (maxr >= nums.length - 1) 
            return true;
        }
        return true;
    }
}