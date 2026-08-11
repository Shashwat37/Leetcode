class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] f = new int[5];
        int frogs = 0;
        int ans = 0;

        for (char c : croakOfFrogs.toCharArray()) {
            int x = c == 'c' ? 0 :
                    c == 'r' ? 1 :
                    c == 'o' ? 2 :
                    c == 'a' ? 3 : 4;

            if (x == 0) {
                f[0]++;
                frogs++;
                ans = Math.max(ans, frogs);
            } else {
                if (f[x - 1] == 0) {
                    return -1;
                }

                f[x - 1]--;
                f[x]++;

                if (x == 4) {
                    f[4]--;
                    frogs--;
                }
            }
        }

        return frogs == 0 ? ans : -1;
    }
}