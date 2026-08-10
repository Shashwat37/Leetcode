class Solution {
    public boolean isThree(int n) {
        int x = (int) Math.sqrt(n);

        return x * x == n && isPrime(x);
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}