class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] arr = new int[intervals.length][2];
        int c = 0;

        arr[c][0] = intervals[0][0];
        arr[c][1] = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= arr[c][1]) {
                arr[c][1] = Math.max(arr[c][1], intervals[i][1]);
            }
            else {
                c++;
                arr[c][0] = intervals[i][0];
                arr[c][1] = intervals[i][1];
            }
        }
        int[][] result = new int[c + 1][2];
        for (int i = 0; i <= c; i++) {
            result[i] = arr[i];
        }

        return result;
    }
}
