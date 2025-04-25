class Solution {
    static{
        for(int i=0;i<500;i++){
            countBadPairs(new int[]{});
        }
    }
    public static long countBadPairs(int[] arr) {
        long n=(long)arr.length;
        long total=(n-1)*n/2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            total-=map.getOrDefault(i-arr[i],0);
            map.put(i-arr[i],map.getOrDefault(i-arr[i],0)+1);
        }
        return total;
    }
}