class Solution {
    public long interchangeableRectangles(int[][] arr) {
        HashMap<Double,Long> map=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            double num=arr[i][1]*1.0/arr[i][0];
            map.put(num,map.getOrDefault(num,0L)+1);
        }
        long ans=0;
        System.out.println(map);
        for(Double num:map.keySet()){
            long val=map.get(num);
            ans+=(val*(val-1))/2;
        }
        return ans;
    }
}