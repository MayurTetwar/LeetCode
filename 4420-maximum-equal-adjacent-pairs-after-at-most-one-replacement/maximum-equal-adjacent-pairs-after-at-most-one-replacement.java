class Solution {
    public int maxEqualAdjacentPairs(int[] arr) {
        int n=arr.length;
        int ans=0;
        HashMap<Long,Integer> map=new HashMap<>();
        for(int i=0;i<n-1;i++){
            long num1=arr[i];
            long num2=arr[i+1];
            if(num1==num2){
                ans++;
                continue;
            }
            if(num2>num1){
                long temp=num1;
                num1=num2;
                num2=temp;
            }
            long res=(num1<<31)+num2;
            map.put(res,map.getOrDefault(res,0)+1);
        }
        int ans2=0;
        for(int val:map.values()){
            ans2=Math.max(ans2,val);
        }
        return ans+ans2;
    }
}