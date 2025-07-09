class Solution {
    public int maxFreeTime(int t, int k, int[] st, int[] end) {
        int n=st.length;
        int max=0;
        int[] pre=new int[n];
        pre[0]=st[0];
        for(int i=1;i<n;i++){
            pre[i]=(st[i]-end[i-1])+pre[i-1];
        }
        int left=0;
        int right=k-1;
        while(right<n){
            int leftrem=(left==0)?st[left]:st[left]-end[left-1];
            int rightrem=(right==n-1)?t-end[right]:st[right+1]-end[right];
            max=Math.max(max,pre[right]-pre[left]+leftrem+rightrem);
           // System.out.println(pre[right]-pre[left]+" "+leftrem+" "+rightrem);
            left++;
            right++;
        }
        return max;
    }
}