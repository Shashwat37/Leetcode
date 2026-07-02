class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (n < 4) return result;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: First loop (first number)
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Step 3: Second loop (second number)
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second numbers
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 4: Two pointers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate third numbers
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicate fourth numbers
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                    else if (sum < target) {
                        left++;   // Increase sum
                    }
                    else {
                        right--;  // Decrease sum
                    }
                }
            }
        }
        return result;
    }
}
