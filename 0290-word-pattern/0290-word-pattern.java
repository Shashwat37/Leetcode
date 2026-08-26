class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] a = s.split(" ");

        if (a.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (map.containsKey(c)) {
                if (!map.get(c).equals(a[i])) {
                    return false;
                }
            } else {
                if (set.contains(a[i])) {
                    return false;
                }

                map.put(c, a[i]);
                set.add(a[i]);
            }
        }

        return true;
    }
}