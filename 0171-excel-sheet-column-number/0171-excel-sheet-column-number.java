class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            int x = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + x;
        }

        return ans;
    }
}