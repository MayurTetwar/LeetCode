class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            minimumAddedInteger(new int[] { 9, 2, 3 }, new int[] { 9 });
        }
    }

    public static int minimumAddedInteger(int[] arr, int[] arr2) {
        int[] map = new int[3002];
        int n = arr.length;
        int m = arr2.length;
        int min1 = 20000;
        int max1 = -20000;
        int min2 = 20000;
        int max2 = -20000;
        for (int i = 0; i < m; i++) {
            map[arr2[i] + 1000]++;
            min1 = Math.min(min1, arr2[i]);
            max1 = Math.max(max1, arr2[i]);
        }
        for (int i = 0; i < n; i++) {
            max2 = Math.max(max2, arr[i]);
            min2 = Math.min(min2, arr[i]);
        }
        min1 = Math.min(min1, min2);
        max1 = Math.max(max1, max2);
        int limit = Math.max(min1 - max1, max1 - min1);
        // System.out.println(limit);
        for (int i = -limit; i <= limit; i++) {
            if (helper(i, map.clone(), arr, m))
                return i;
        }
        return 0;
    }

    public static boolean helper(int mid, int[] map, int[] arr, int limit) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map[arr[i] + mid + 1000] > 0) {
                count++;
                map[arr[i] + mid + 1000]--;
            }
            if(count>limit)return false;
        }
        if (count == limit)
            return true;
        return false;
    }
}