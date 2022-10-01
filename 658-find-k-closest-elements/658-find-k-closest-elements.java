class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int positions[] = sameValueRange(arr, x);

        //mid can be starting point 0
        //mid can be ending point length-1
        //or middle where one side has less element so need to pick from other side
        //learnt -
        //1. did not thought of unequal indexes available
        //2. same x element found then priority and direction
        List<Integer> list = new ArrayList<>();
        if (positions[0] == 0) {
            if (arr[positions[0]] != x) {
                handleComparisonCase(arr, list, k, 0, positions, x);
            } else {
                for (int i = 0; i < k; i++) {
                    list.add(arr[i]);
                }
            }
        } else if (positions[1] == arr.length - 1) {
            if (arr[positions[1]] != x) {
                handleComparisonCase(arr, list, k, 0, positions, x);
            } else {
                for (int i = arr.length - k; i < arr.length; i++) {
                    list.add(arr[i]);
                }
            }
        } else {
            int sameLength = (positions[1] + 1) - positions[0];
            if (sameLength == 1 && arr[positions[0]] != x && positions[0] > 0 && positions[0] < arr.length - 1) {
                int diff1 = Math.abs(x - arr[positions[0]]);
                int diff2 = Math.abs(x - arr[positions[0] - 1]);
                int diff3 = Math.abs(x - arr[positions[0] + 1]);
                if (diff2 < diff1 && diff2 < diff3) {
                    positions[0]--;
                    positions[1]--;
                } else if (diff3 < diff2 && diff3 < diff1) {
                    positions[0]++;
                    positions[1]++;
                }
            }
            if (sameLength >= k && arr[positions[0]] == x && arr[positions[1]] == x) {
                int start = positions[0];
                int end = start + (k - 1);
                for (int i = start; i <= end; i++) {
                    list.add(arr[i]);
                }
                return list;
            } else {
                sameLength = arr[positions[0]] == x && arr[positions[1]] == x ? sameLength : 0;
                handleComparisonCase(arr, list, k, sameLength, positions, x);
            }
        }
        return list.subList(0, k);
    }

    private void handleComparisonCase(int[] arr, List<Integer> list, int k, int sameLength, int[] positions, int x) {
        int i = 0;
        int kk = k - sameLength;
        int pos = positions[0];
        for (int j = 0; j < sameLength; j++) {
            list.add(arr[pos++]);
        }
        int l = positions[0] - 1;
        Integer m = sameLength == 0 ? positions[0] : null;
        int r = positions[1] + 1;

        int diff1 = l >= 0 ? x - arr[l] : Integer.MAX_VALUE;
        int diff1_5 = m != null && m >= 0 && m <= arr.length - 1 ? Math.abs(x - arr[m]) : Integer.MAX_VALUE;
        int diff2 = r <= arr.length - 1 ? arr[r] - x : Integer.MAX_VALUE;
        boolean extraToAdd = false;
        if (m != null) {
            if (diff1_5 < diff1 && diff1_5 <= diff2) {
                list.add(arr[m]);
                kk--;
            } else if (diff1_5 <= diff1 && diff1_5 <= diff2) {
                extraToAdd = true;
            }
        }
        while (i < kk) {
            diff1 = l >= 0 ? x - arr[l] : Integer.MAX_VALUE;
            diff2 = r <= arr.length - 1 ? arr[r] - x : Integer.MAX_VALUE;
            if (diff1 <= diff2) {
                list.add(0, arr[l--]);
                if (extraToAdd) {
                    list.add(arr[m]);
                    extraToAdd = false;
                    i++;
                }
            } else {
                list.add(arr[r++]);
            }
            i++;
        }
                /*int kk = sameLength == 1 ? k : k - sameLength;
                int start = -1;
                int end = -1;
                if (positions[0] >= (kk + 1) / 2) {
                    *//*start = positions[0] - (kk + 1) / 2;
                    end = start + (k - 1);*//*

                } else {
                    start = 0;
                    end = k - 1;
                }


                for (int i = start; i <= end; i++) {
                    list.add(arr[i]);
                }*/
    }

    private int[] sameValueRange(int[] arr, int x) {
        int pos = nearestIndex(arr, x);
        int start = pos;
        int end = pos;
        while (start - 1 >= 0 && arr[start - 1] == x) {
            start--;
        }

        while (end + 1 <= arr.length - 1 && arr[end + 1] == x) {
            end++;
        }

        return new int[]{start, end};
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