import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new int[]{i, freq[i]});
            }
        }

        StringBuilder ans = new StringBuilder();

        while (pq.size() >= 2) {
            int[] a = pq.poll();
            int[] b = pq.poll();

            ans.append((char) (a[0] + 'a'));
            ans.append((char) (b[0] + 'a'));

            a[1]--;
            b[1]--;

            if (a[1] > 0) {
                pq.add(a);
            }

            if (b[1] > 0) {
                pq.add(b);
            }
        }

        if (!pq.isEmpty()) {
            int[] a = pq.poll();

            if (a[1] > 1) {
                return "";
            }

            ans.append((char) (a[0] + 'a'));
        }

        return ans.toString();
    }
}