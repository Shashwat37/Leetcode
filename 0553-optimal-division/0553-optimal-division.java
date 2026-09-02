class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return "" + nums[0];
        }

        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }

        StringBuilder s = new StringBuilder();

        s.append(nums[0]).append("/(");

        for (int i = 1; i < nums.length; i++) {
            s.append(nums[i]);

            if (i != nums.length - 1) {
                s.append("/");
            }
        }

        s.append(")");

        return s.toString();
    }
}