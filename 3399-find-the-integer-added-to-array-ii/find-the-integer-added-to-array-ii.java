class Solution {
    public int minimumAddedInteger(int[] arr, int[] arr2) {
        int[] map=new int[3002];
        int n=arr.length;
        int m=arr2.length;
        // int min=20000;
        // int max=-20000;
        for(int i=0;i<m;i++){
            map[arr2[i]+1000]++;
           // min=Math.min(min,arr2[i]);
        }
        // for(int i=0;i<n;i++){
        //     max=Math.max(max,arr[i]);
        // }
       // int limit=Math.max(max-min,min+max);
        //System.out.println(limit);
        for(int i=-1000;i<1000;i++){
            if(helper(i,map.clone(),arr,m))return i;
        }
        return 0;
    }
    public boolean helper(int mid,int[] map,int[] arr,int limit){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(map[arr[i]+mid+1000]>0){
                count++;
                map[arr[i]+mid+1000]--;
            }
        }
        if(count==limit)return true;
        return false;
    }
}