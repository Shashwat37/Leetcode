class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(s.substring(0, i));
                List<Integer> right = diffWaysToCompute(s.substring(i + 1));

                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') {
                            ans.add(a + b);
                        } else if (c == '-') {
                            ans.add(a - b);
                        } else {
                            ans.add(a * b);
                        }
                    }
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(s));
        }

        return ans;
    }
}