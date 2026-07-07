class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        if(s.length() != t.length())
            return false;

        char ch;

        // Step 1: Build frequency map from s
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if(map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }

        // Step 2: Compare with t
        for(int i = 0; i < t.length(); i++) {
            ch = t.charAt(i);

            if(!map.containsKey(ch))
                return false;

            map.put(ch, map.get(ch) - 1);

            if(map.get(ch) < 0)
                return false;
        }

        return true;
    }
}