class Solution { 
    boolean[] visi;
    int ans;
    public int numSquarefulPerms(int[] arr) {
        int n=arr.length;
        ans=0;
        visi=new boolean[n];
        Arrays.sort(arr);
        helper(arr,-1,0);
        return ans;
    }
    public void helper(int[] arr,int last,int i){
        if(i==arr.length){
            ans++;
            return ;
        }
        for(int j=0;j<arr.length;j++){
            if(j>0 && arr[j]==arr[j-1] && !visi[j-1])continue;
            if(!visi[j] && (isPerSqr(arr[j]+last) || last==-1)){
                visi[j]=true; 
                helper(arr,arr[j],i+1);
                visi[j]=false;
            }
        }
        return;
    }
    public boolean isPerSqr(int n){
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}