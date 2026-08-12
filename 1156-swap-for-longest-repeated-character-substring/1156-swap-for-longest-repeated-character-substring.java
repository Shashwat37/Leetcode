class Solution {
    public int maxRepOpt1(String text) {
        int n = text.length();
        int[] count = new int[26];
        for (char c : text.toCharArray()) count[c - 'a']++;

        List<Character> chars = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) j++;
            chars.add(text.charAt(i));
            lens.add(j - i);
            i = j;
        }

        int res = 0;
        int m = chars.size();
        for (int k = 0; k < m; k++) {
            char c = chars.get(k);
            int len = lens.get(k);
            res = Math.max(res, Math.min(len + 1, count[c - 'a']));
            if (k + 2 < m && chars.get(k) == chars.get(k + 2) && lens.get(k + 1) == 1) {
                int total = len + lens.get(k + 2);
                res = Math.max(res, Math.min(total + 1, count[c - 'a']));
            }
        }
        return res;
    }
}