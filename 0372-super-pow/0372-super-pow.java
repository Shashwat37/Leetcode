class Solution {
    public int superPow(int a, int[] b) {
        int ans = 1;
        a %= 1337;

        for (int x : b) {
            ans = pow(ans, 10) * pow(a, x) % 1337;
        }

        return ans;
    }

    public int pow(int a, int b) {
        int ans = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                ans = ans * a % 1337;
            }

            a = a * a % 1337;
            b /= 2;
        }

        return ans;
    }
}