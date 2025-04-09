class Solution {
    public int minOperations(int[] arr, int k) {
        int n=arr.length;
        int ans=0;
        int[] map=new int[101];
        for(int num:arr){
            if(num<k)return -1;
            if(num==k)continue;
            if(map[num]==0)ans++;
            map[num]++;
        }
        return ans;
    }
}