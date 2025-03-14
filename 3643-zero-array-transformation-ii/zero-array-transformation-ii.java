class Solution {
    public int minZeroArray(int[] arr, int[][] que) {
        int n=arr.length;
        int[] diff=new int[n+1];
        int sum=0,k=0;
        for(int i=0;i<n;i++){
            //System.out.println(arr[i]+" "+diff[i]+" "+sum+" "+j+" "+i);     
            //if(arr[i]==0)continue;
            while(sum+diff[i]<arr[i]){
                k++;
                if(k>que.length)return -1;
                if(que[k-1][1]>=i){
                    diff[Math.max(que[k-1][0],i)]+=que[k-1][2];
                    diff[que[k-1][1]+1]-=que[k-1][2];
                }
            }
            sum+=diff[i];
        }
        //System.out.println(sum+" "+j+" "+Arrays.toString(diff));
        return k;
    }
}