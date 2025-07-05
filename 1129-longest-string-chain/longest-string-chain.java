class Solution {
    int memo[];
    public int longestStrChain(String[] arr) {
        int n=arr.length;
        int ans=0;
        Arrays.sort(arr, (a, b) -> Integer.compare(a.length(), b.length()));
        memo=new int[n];
        Arrays.fill(memo,-1);
        for(int i=0;i<n;i++){
            ans=Math.max(ans,1+helper(arr,i));
        }
        return ans;
    }
    public int helper(String[] arr,int i){
        if(i==arr.length){
            return 0;
        }
        if(memo[i]!=-1)return memo[i];
        int ans=0;
        for(int j=i+1;j<arr.length;j++){
            if(isPre(arr[i],arr[j])){
                ans=Math.max(ans,1+helper(arr,j));
            }
        }
        return memo[i]=ans;
    }
    public boolean isPre(String s,String s2){
        int n=s.length();
        int m=s2.length();
        if(n+1!=m)return false;
        int i=0;
        while(i<n && s.charAt(i)==s2.charAt(i))i++;
        if(i==n)return true;
        if(s.substring(i,n).equals(s2.substring(i+1,m))){
            return true;
        }
        return false;
    }
}