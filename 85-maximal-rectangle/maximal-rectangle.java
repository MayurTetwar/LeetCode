class Solution {
    public int maximalRectangle(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[] dp=new int[m];
        Arrays.fill(dp,1);
        int ans=0;
        for(int i=0;i<n;i++){
            int[] left=new int[m];
            int[] right=new int[m];
            Stack<Integer> stk=new Stack<>();
            for(int j=0;j<m;j++){
                if((arr[i][j]-'0')==1)dp[j]++;
                else dp[j]=1;
                while(!stk.isEmpty() && dp[stk.peek()]>=dp[j]){
                    stk.pop();
                }
                if(stk.size()>0)left[j]=stk.peek();
                else left[j]=-1;
                stk.push(j);
            }
           // System.out.println(Arrays.toString(dp));
            stk=new Stack<>();
            for(int j=m-1;j>=0;j--){
                while(!stk.isEmpty() && dp[stk.peek()]>=dp[j]){
                    stk.pop();
                }
                if(stk.size()>0) ans=Math.max(ans,(stk.peek()-left[j]-1)*(dp[j]-1));
                else ans=Math.max(ans,(m-left[j]-1)*(dp[j]-1));
                stk.push(j);
            }
            // for(int j=0;j<m;j++){
            //     ans=Math.max(ans,(right[j]-left[j]-1)*(dp[j]-1));
            // }
        }
        return ans;
    }
}