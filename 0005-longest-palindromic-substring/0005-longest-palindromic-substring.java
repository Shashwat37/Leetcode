class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        String longest = "";

        for (int i = 0; i < s.length(); i++) {

            int left = i;
            int right = i;

            while (left >= 0 && right < s.length()) {

                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }

                String current = s.substring(left, right + 1);

                if (current.length() > longest.length()) {
                    longest = current;
                }

                left--;
                right++;
            }


            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length()) {

                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }

                String current = s.substring(left, right + 1);

                if (current.length() > longest.length()) {
                    longest = current;
                }

                left--;
                right++;
            }
        }

        return longest;
    }
}