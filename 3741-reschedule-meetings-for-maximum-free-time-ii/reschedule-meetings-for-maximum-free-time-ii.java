class Solution {
    public int maxFreeTime(int t, int[] st, int[] end) {
        int n=st.length;
        int max=0;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=st[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],st[i]-end[i-1]);
        }
        right[n-1]=t-end[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],st[i+1]-end[i]);
        }
        for(int i=0;i<n;i++){
            int leftrem=(i==0)?st[i]:st[i]-end[i-1];
            int rightrem=(i==n-1)?t-end[i]:st[i+1]-end[i];
            int gap=leftrem+rightrem+end[i]-st[i];
            if((i>0 && left[i-1]>=end[i]-st[i])||(i<n-1 && right[i+1]>=end[i]-st[i])){
                max=Math.max(max,gap);
            }else{
                max=Math.max(max,leftrem+rightrem);
            }
        }
        return max;
    }
}