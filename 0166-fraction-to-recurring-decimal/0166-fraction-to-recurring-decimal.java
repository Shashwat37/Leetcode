class Solution {
    public String fractionToDecimal(int num, int den) {
        if (num == 0) return "0";

        StringBuilder s = new StringBuilder();

        if ((num < 0) ^ (den < 0)) {
            s.append("-");
        }

        long a = Math.abs((long) num);
        long b = Math.abs((long) den);

        s.append(a / b);
        long r = a % b;

        if (r == 0) return s.toString();

        s.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (r != 0) {
            if (map.containsKey(r)) {
                s.insert(map.get(r), "(");
                s.append(")");
                break;
            }

            map.put(r, s.length());

            r *= 10;
            s.append(r / b);
            r %= b;
        }

        return s.toString();
    }
}