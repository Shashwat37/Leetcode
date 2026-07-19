class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle))
        {
            int idx=haystack.indexOf(needle);
            return idx;
        }
        else
        return -1;
    }
}