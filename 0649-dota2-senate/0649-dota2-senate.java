class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int a = r.poll();
            int b = d.poll();

            if (a < b) {
                r.offer(a + n);
            } else {
                d.offer(b + n);
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}