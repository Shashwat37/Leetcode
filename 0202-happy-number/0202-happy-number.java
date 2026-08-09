class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sum(slow);
            fast = sum(sum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int sum(int n) {
        int ans = 0;

        while (n > 0) {
            int d = n % 10;
            ans += d * d;
            n /= 10;
        }

        return ans;
    }
}