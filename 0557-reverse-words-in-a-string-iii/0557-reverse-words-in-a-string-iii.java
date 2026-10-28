class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int l = 0;

        for (int i = 0; i <= a.length; i++) {
            if (i == a.length || a[i] == ' ') {
                int r = i - 1;

                while (l < r) {
                    char temp = a[l];
                    a[l] = a[r];
                    a[r] = temp;

                    l++;
                    r--;
                }

                l = i + 1;
            }
        }

        return new String(a);
    }
}