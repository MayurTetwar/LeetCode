class Solution {
    public int minRotations(int n, String s) {
        int[] dis=new int[n];
        int first=s.charAt(0)-'0';
        int last=s.charAt(n-1)-'0';
        dis[n-1]=Math.min(last,10-last);
        for(int i=n-2;i>=0;i--){
            int val1=s.charAt(i)-'0';
            int val2=s.charAt(i+1)-'0';
            int d=Math.abs(val1-val2);
            dis[i]=Math.min(d,10-d)+dis[i+1];
        }

        // System.out.println(Arrays.toString(dis));

        int ans=dis[0];
        int fordis=Math.min(first,10-first);
        for(int i=0;i<n-1;i++){
            int val1=s.charAt(i)-'0';
            int val2=s.charAt(i+1)-'0';
            int d=Math.abs(last-val1);
            d=Math.min(d,10-d);
            // System.out.println(fordis+" "+d+" "+dis[i+1]);
            ans=Math.min(ans, fordis+d+dis[i+1]-dis[n-1]);
            d=Math.abs(val1-val2);
            fordis+=Math.min(d,10-d);
        }
        return ans;

    }
}