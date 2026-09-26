import java.util.*;

class Solution {
    public int flipLights(int n, int presses) {
        n = Math.min(n, 6);

        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        char[] a = new char[n];

        for (int i = 0; i < n; i++) {
            a[i] = '1';
        }

        String start = new String(a);

        q.add(start);
        set.add(start);

        for (int p = 0; p < presses; p++) {
            int size = q.size();

            HashSet<String> next = new HashSet<>();

            for (int z = 0; z < size; z++) {
                String s = q.poll();

                for (int type = 0; type < 4; type++) {
                    char[] b = s.toCharArray();

                    for (int i = 0; i < n; i++) {
                        boolean flip = false;

                        if (type == 0) {
                            flip = true;
                        } else if (type == 1 && i % 2 == 1) {
                            flip = true;
                        } else if (type == 2 && i % 2 == 0) {
                            flip = true;
                        } else if (type == 3 && i % 3 == 0) {
                            flip = true;
                        }

                        if (flip) {
                            b[i] = b[i] == '1' ? '0' : '1';
                        }
                    }

                    String ns = new String(b);

                    if (next.add(ns)) {
                        q.add(ns);
                    }
                }
            }
        }

        return q.size();
    }
}