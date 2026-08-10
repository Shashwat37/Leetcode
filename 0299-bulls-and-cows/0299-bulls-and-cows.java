class Solution {
    public String getHint(String secret, String guess) {
        int[] f = new int[10];
        int bull = 0;
        int cow = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                f[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                int x = guess.charAt(i) - '0';

                if (f[x] > 0) {
                    cow++;
                    f[x]--;
                }
            }
        }

        return bull + "A" + cow + "B";
    }
}