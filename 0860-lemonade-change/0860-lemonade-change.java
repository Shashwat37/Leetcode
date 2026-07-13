import java.util.HashMap;

class Solution {
    public boolean lemonadeChange(int[] bills) {

        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i = 0; i < bills.length; i++) {

            int b = bills[i];
            int ch = b - 5;

            if (ch > 0) {

                int n20 = ch / 20;
                int h20 = 0;

                if (mp.containsKey(20)) {
                    h20 = mp.get(20);
                }

                int u20 = Math.min(n20, h20);

                ch = ch - (u20 * 20);
                mp.put(20, h20 - u20);



                int n10 = ch / 10;
                int h10 = 0;

                if (mp.containsKey(10)) {
                    h10 = mp.get(10);
                }

                int u10 = Math.min(n10, h10);

                ch = ch - (u10 * 10);
                mp.put(10, h10 - u10);



                int n5 = ch / 5;
                int h5 = 0;

                if (mp.containsKey(5)) {
                    h5 = mp.get(5);
                }

                int u5 = Math.min(n5, h5);

                ch = ch - (u5 * 5);
                mp.put(5, h5 - u5);



                if (ch != 0) {
                    return false;
                }
            }

            if (mp.containsKey(b)) {
                mp.put(b, mp.get(b) + 1);
            } else {
                mp.put(b, 1);
            }
        }

        return true;
    }
}