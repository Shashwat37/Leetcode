class Solution {
    public int primePalindrome(int n) {
        while (true) {
            if (isPal(n) && isPrime(n)) {
                return n;
            }

            if (n > 10000000 && n < 100000000) {
                n = 100000000;
            } else {
                n++;
            }
        }
    }

    private boolean isPal(int n) {
        int x = n;
        int rev = 0;

        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return rev == n;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}