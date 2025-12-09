class Solution {
    public long totalScore(int hp, int[] d, int[] r) {
        long ans=0;
        int n=d.length;
        int[] pre=new int[n+1];
        for(int i=1;i<=n;i++){
            pre[i]=pre[i-1]+d[i-1];
        }
        for(int i=1;i<=n;i++){
            long tar=pre[i]+r[i-1]-hp;
            int st=0,end=i;
            while(st<end){
                int mid=(st+end)/2;
                if(pre[mid]>=tar)end=mid;
                else st=mid+1;
            }
            ans+=(i-st);
        }
        return ans;
    }
}