class Solution {
    public int beautySum(String s) {
        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];

            for(int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                int max = 0;
                int min = s.length();

                for(int f : freq) {
                    if(f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }

                ans += max - min;
            }
        }

        return ans;
    }
}