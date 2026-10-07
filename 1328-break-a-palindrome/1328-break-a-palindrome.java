class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();

        if (n == 1) {
            return "";
        }

        char[] a = palindrome.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            if (a[i] != 'a') {
                a[i] = 'a';
                return new String(a);
            }
        }

        a[n - 1] = 'b';

        return new String(a);
    }
}