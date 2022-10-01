class Solution {
    //mid can be starting point 0
    //mid can be ending point length-1
    //or middle where one side has less element so need to pick from other side
    //learnt -
    //1. did not thought of unequal indexes available
    //2. same x element found then priority and direction
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = nearestIndex(arr, x);
        List<Integer> list = new ArrayList<>();
        handleComparisonCase(arr, list, k, pos, x);
        return list.subList(0, k);
    }

    private void handleComparisonCase(int[] arr, List<Integer> list, int k, int pos, int x) {
        int i = 0;
        int l = pos - 1;
        Integer m = pos;
        int r = pos + 1;

        int diff1 = l >= 0 ? x - arr[l] : Integer.MAX_VALUE;
        int diff1_5 = m != null && m >= 0 && m <= arr.length - 1 ? Math.abs(x - arr[m]) : Integer.MAX_VALUE;
        int diff2 = r <= arr.length - 1 ? arr[r] - x : Integer.MAX_VALUE;
        boolean extraToAdd = true;
        if (m != null) {
            if (diff1_5 < diff1 && diff1_5 <= diff2) {
                list.add(arr[m]);
                extraToAdd = false;
                k--;
            }
        }
        while (i < k) {
            diff1 = l >= 0 ? x - arr[l] : Integer.MAX_VALUE;
            diff2 = r <= arr.length - 1 ? arr[r] - x : Integer.MAX_VALUE;
            if(extraToAdd && diff1_5<diff1 && diff1_5<diff2){
                list.add(arr[m]);
                list.sort(Integer::compareTo);
                extraToAdd = false;
                i++;
            }
            if (diff1 <= diff2) {
                list.add(0, arr[l--]);
            }else {
                list.add(arr[r++]);
            }
            i++;
        }
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