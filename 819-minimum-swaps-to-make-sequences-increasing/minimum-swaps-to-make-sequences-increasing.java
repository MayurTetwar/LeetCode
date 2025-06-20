class Solution {
    int[][] memo;
    public int minSwap(int[] nums1, int[] nums2) {
        memo=new int[2][nums1.length];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(nums1,nums2,0,false,-1,-1);
    }
    public int helper(int[] arr1,int[] arr2,int i,boolean swap,int prev1,int prev2){
        if(i==arr1.length){
            return 0;
        }
        if(memo[(swap?0:1)][i]!=-1)return memo[(swap?0:1)][i];
        int res=Integer.MAX_VALUE;
        if(swap){
            int temp=prev1;
            prev1=prev2;
            prev2=temp;
        }
        if(prev1<arr1[i] && prev2<arr2[i]){
            res=Math.min(res,helper(arr1,arr2,i+1,false,arr1[i],arr2[i]));
        }
        if(prev1<arr2[i] && prev2<arr1[i]){
            res=Math.min(res,helper(arr1,arr2,i+1,true,arr1[i],arr2[i])+1);
        }
        return memo[(swap?0:1)][i]=res;
    }
}