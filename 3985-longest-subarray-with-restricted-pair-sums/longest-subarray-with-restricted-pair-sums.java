class Solution {
    public int maxSubarray(int[] arr) {
        int n=arr.length;
        int ans=Math.min(2,n);
        int[] valid=new int[n];
        Arrays.fill(valid,n);
        for(int i=0;i<n-2;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            map.put(arr[n-1],n-1);
            for(int j=n-2;j>i;j--){
                int val=arr[j]+arr[i];
                if(map.containsKey(val)){
                    valid[i]=Math.min(valid[i],map.get(val));
                }
                val=Math.abs(arr[j]-arr[i]);
                if(map.containsKey(val)){
                    valid[i]=Math.min(valid[i],map.get(val));
                }
                map.put(arr[j],j);
            }
        }
        // System.out.println(Arrays.toString(valid));
        int min=n;
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,valid[i]);
            ans=Math.max(ans,min-i);
        }
        return ans;
    }
}
// 2 6 7 1