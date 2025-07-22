class Solution {
    public int maximumUniqueSubarray(int[] arr) {
        int[] last=new int[10001];
        boolean[] visi=new boolean[10001];
        int max=0;
        int sum=0;
        int n=arr.length;
        int j=0;
        for(int i=0;i<n;i++){
            while(j<i && visi[arr[i]]){
                sum-=arr[j];
                visi[arr[j]]=false;
                j++;
            }
            visi[arr[i]]=true;
            sum+=arr[i];
            max=Math.max(max,sum);
        }
        return Math.max(max,sum);
    }
}