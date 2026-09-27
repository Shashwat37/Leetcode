import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>();

        for (String s : bank) {
            set.add(s);
        }

        if (!set.contains(endGene)) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.add(startGene);

        HashSet<String> vis = new HashSet<>();
        vis.add(startGene);

        char[] ch = {'A', 'C', 'G', 'T'};
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int x = 0; x < size; x++) {
                String cur = q.poll();

                if (cur.equals(endGene)) {
                    return steps;
                }

                char[] a = cur.toCharArray();

                for (int i = 0; i < 8; i++) {
                    char old = a[i];

                    for (char c : ch) {
                        if (c == old) {
                            continue;
                        }

                        a[i] = c;
                        String next = new String(a);

                        if (set.contains(next) && !vis.contains(next)) {
                            vis.add(next);
                            q.add(next);
                        }
                    }

                    a[i] = old;
                }
            }

            steps++;
        }

        return -1;
    }
}