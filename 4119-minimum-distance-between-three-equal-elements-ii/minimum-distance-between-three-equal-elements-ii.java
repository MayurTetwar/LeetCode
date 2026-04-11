class Solution {
    public int minimumDistance(int[] arr) {
        int n=arr.length;
        int ans=n*3;
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] prev=new int[n];
        for(int i=0;i<n;i++){
            int pre=map.getOrDefault(arr[i],-1);
            prev[i]=pre;
            map.put(arr[i],i);
        }
        map=new HashMap<>();
        for(int i=0;i<n;i++){
            int pre=map.getOrDefault(arr[i],-1);
            if(pre!=-1){
                int pre2=prev[pre];
                if(pre2!=-1){
                    ans=Math.min(ans,Math.abs(i-pre)+Math.abs(pre-pre2)+Math.abs(i-pre2));
                }
            }
            map.put(arr[i],i);
        }
        return (ans==3*n)?-1:ans;
    }
}