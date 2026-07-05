class Solution {
    public int findKthPositive(int[] arr, int k) {

        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        int missingCount = 0;
        int num = 1;

        while (true) {
            if (!set.contains(num)) {
                missingCount++;
                if (missingCount == k) {
                    return num;
                }
            }
            num++;
        }
    }
}
