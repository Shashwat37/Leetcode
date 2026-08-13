import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = num.substring(0, i);
                String b = num.substring(i, j);
                if ((a.length() > 1 && a.charAt(0) == '0') ||
                    (b.length() > 1 && b.charAt(0) == '0')) continue;

                BigInteger first = new BigInteger(a);
                BigInteger second = new BigInteger(b);
                int pos = j;
                boolean ok = true;

                while (pos < n) {
                    BigInteger sum = first.add(second);
                    String sumStr = sum.toString();
                    if (!num.startsWith(sumStr, pos)) {
                        ok = false;
                        break;
                    }
                    pos += sumStr.length();
                    first = second;
                    second = sum;
                }

                if (ok && pos == n) return true;
            }
        }
        return false;
    }
}