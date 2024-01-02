class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);
        boolean[] isUsed = new boolean[nums.length];
        List<LinkedHashSet<Integer>> resultList = new ArrayList<>();
        int totalUsed = 0;
        for (int j = 0; totalUsed < nums.length; j++) {
            resultList.add(new LinkedHashSet<>());
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int foundIndex = Arrays.binarySearch(numsSorted, num);
                if (!isUsed[i] && foundIndex > -1) {
                    if (!resultList.get(j).contains(num)) {
                        resultList.get(j).add(num);
                        isUsed[i] = true;
                        totalUsed++;
                    }
                }
            }
        }
        return convert(resultList);
    }
    private static List<List<Integer>> convert(List<LinkedHashSet<Integer>> resultList) {
        List<List<Integer>> finalList = new ArrayList<>();
        for (LinkedHashSet<Integer> linkedHashSetInteger : resultList) {
            finalList.add(new ArrayList<>(linkedHashSetInteger));
        }
        return finalList;
    }
}
