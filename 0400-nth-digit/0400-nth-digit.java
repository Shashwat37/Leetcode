class Solution {
    public int findNthDigit(int n) {
        long len = 1;
        long count = 9;
        long start = 1;

        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        long num = start + (n - 1) / len;
        int idx = (int) ((n - 1) % len);

        return String.valueOf(num).charAt(idx) - '0';
    }
}