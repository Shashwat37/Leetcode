class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }

        int max = (int) Math.pow(10, n) - 1;
        int min = (int) Math.pow(10, n - 1);

        for (int i = max; i >= min; i--) {
            long p = i;
            String s = String.valueOf(p);
            String rev = new StringBuilder(s).reverse().toString();

            long pal = Long.parseLong(s + rev);

            for (long j = max; j * j >= pal; j--) {
                if (pal % j == 0 && pal / j <= max && pal / j >= min) {
                    return (int) (pal % 1337);
                }
            }
        }

        return 0;
    }
}