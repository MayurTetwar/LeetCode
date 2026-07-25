class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=n-i;
        }
        int num=n;
        int i=0;
        while(k>0){
            ans[i]=num;
            if(i%2==0)num-=k;
            else num+=k;
            k--;
            i++;
        }
        ans[i]=num;
        return ans;
    }
    /*
    4 3 2 1
    4 2 1 3
    4 1 3 2

    5 3 4 2 1 

    */
}