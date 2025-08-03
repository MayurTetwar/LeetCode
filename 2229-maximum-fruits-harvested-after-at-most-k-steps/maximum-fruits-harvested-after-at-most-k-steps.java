class Solution {
    public int maxTotalFruits(int[][] arr, int st, int k) {
        int n=arr.length;
        int len=Math.max(st,arr[n-1][0])+1;
        int[] count=new int[len];
        for(int i=0;i<n;i++){
            count[arr[i][0]]=arr[i][1];
        }
        for(int i=1;i<len;i++){
            count[i]+=count[i-1];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int ind=arr[i][0];
            if(st>ind && st-ind>k)continue;
            if(ind>st && ind-st>k)continue;
            int step=Math.abs(ind-st);
            int extra=0;
            if(st!=ind){
                extra=Math.abs(count[st]-count[ind]);
            }
            int leftInd=Math.max(0,ind-Math.abs(k-step));
            int left=count[ind]-((leftInd==0)?0:(count[leftInd-1]));
            int rightInd=Math.min(len-1,ind+Math.abs(k-step));
            int right=count[rightInd]-((ind==0)?0:count[ind-1]);
            int exl=0;
            int exr=0;
            if(ind<=st){
                exr=Math.max(extra+arr[i][1],right);
                exl=left+extra; 
            }else{
                exl=Math.max(extra,left);
                exr=right+extra-arr[i][1];
            } 
            // System.out.println(ind+" "+step+" "+extra+" "+leftInd+" "+rightInd+" "+left+" "+right);
            // System.out.println(exl+" "+exr+" "+i);
            ans=Math.max(ans,Math.max(exr,exl));
        }
        return ans;
    }
}