class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int row = 0;
        boolean down = true;

        for (int i = 0; i < s.length(); i++) {
            rows[row] += s.charAt(i);

            if (row == 0) {
                down = true;
            } else if (row == numRows - 1) {
                down = false;
            }

            if (down) {
                row++;
            } else {
                row--;
            }
        }

        String ans = "";

        for (int i = 0; i < numRows; i++) {
            ans += rows[i];
        }

        return ans;
    }
}