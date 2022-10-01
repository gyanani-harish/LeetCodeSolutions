class Solution {
    //mid can be starting point 0
    //mid can be ending point length-1
    //or middle where one side has less element so need to pick from other side
    //learnt -
    //1. did not thought of unequal indexes available
    //2. same x element found then priority and direction
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = nearestIndex(arr, x);
        return handleComparisonCase(arr, k, pos, x);
    }

    private List<Integer> handleComparisonCase(int[] arr, int k, int pos, int x) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int l = arr[pos] != x && pos > 0 ? pos - 1 : pos;
        int r = pos;
        if (l == r) {
            r++;
        }
        while (i++ < k) {
            int diff1 = l >= 0 ? x - arr[l] : Integer.MAX_VALUE;
            int diff2 = r <= arr.length - 1 ? arr[r] - x : Integer.MAX_VALUE;
            if (Math.abs(diff1) <= Math.abs(diff2)) {
                list.add(0, arr[l--]);
            } else {
                list.add(arr[r++]);
            }
        }
        return list;
    }
    
    private int nearestIndex(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return mid;
    }
}