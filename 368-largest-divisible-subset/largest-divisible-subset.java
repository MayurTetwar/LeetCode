class Solution {
    int[] memo;
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n=arr.length;
        memo=new int[n+1];
        int[] temp=new int[n+1];
        Arrays.fill(memo,-1);
        for(int i=0;i<n;i++){
            temp[i+1]=arr[i];
        }
        Arrays.sort(temp);
        temp[0]=1;
        // System.out.println(Arrays.toString(temp));
        int count=helper(temp,0)-1;
        // System.out.println(Arrays.toString(memo)+" "+count);
        int prev=temp[0];
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(memo[i]==count && temp[i]%prev==0){
                list.add(temp[i]);
                count--;
                prev=temp[i];
            }
        }
        return list;
    }
    public int helper(int[] arr,int i){
        int n=arr.length;
        if(i==n)return 0;
        if(memo[i]!=-1)return memo[i];
        int ans=0;
        for(int j=i+1;j<n;j++){
            if(arr[j]%arr[i]==0){
                ans=Math.max(ans,helper(arr,j)+1);
            }
        }
        return memo[i]=ans;
    }

}
/*
helper(temp,1,0);
       
*/