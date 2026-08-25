class Solution {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();

        int l = 0;
        int r = a.length - 1;

        while (l < r) {
            while (l < r && !isVowel(a[l])) {
                l++;
            }

            while (l < r && !isVowel(a[r])) {
                r--;
            }

            char t = a[l];
            a[l] = a[r];
            a[r] = t;

            l++;
            r--;
        }

        return new String(a);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' ||
               c == 'O' || c == 'U';
    }
}