class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> ans = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int j = i + 1;
            int end = intervals[i][1];
            while (j < intervals.length && intervals[j][0] <= end) {
                end = Math.max(intervals[j][1], end);
                j++;
            }
            ans.add(new int[]{intervals[i][0], end});
            i = j - 1;
        }

        return ans.toArray(int[][]::new);
    }
}