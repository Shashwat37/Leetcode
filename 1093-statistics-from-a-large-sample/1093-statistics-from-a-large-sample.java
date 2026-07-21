class Solution {
    public double[] sampleStats(int[] count) {
        int min = -1, max = -1, mode = 0;
        long sum = 0, total = 0;

        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (min == -1) min = i;
                max = i;
                sum += 1L * i * count[i];
                total += count[i];
                if (count[i] > count[mode]) mode = i;
            }
        }

        int left = (int) ((total + 1) / 2);
        int right = (int) ((total + 2) / 2);

        int prefix = 0;
        double median1 = 0, median2 = 0;

        for (int i = 0; i < 256; i++) {
            prefix += count[i];
            if (median1 == 0 && prefix >= left) median1 = i;
            if (prefix >= right) {
                median2 = i;
                break;
            }
        }

        return new double[]{
            min,
            max,
            (double) sum / total,
            (median1 + median2) / 2.0,
            mode
        };
    }
}