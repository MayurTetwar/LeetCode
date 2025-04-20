class Solution {
    public long countFairPairs(int[] arr, int l, int u) {
        Arrays.sort(arr);
        int n=arr.length;
        long ans=0;
        for(int i=0;i<n-1;i++){
            ans+=helper(arr,i+1,n-1,arr[i],l,u);
        }
        return ans;
    }
    public int helper(int[] arr,int stP,int endP,int num,int l,int u){
        int st=stP;
        int end=endP;
        while(st<=end){
            int mid=st+(end-st)/2;
            //System.out.println(st+" "+end);
            if(l<=arr[mid]+num){
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        int least=st;
        st=stP;
        end=endP;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(u<arr[mid]+num){
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        //System.out.println(st+" "+least);
        return st-least;
    }
    // 1 2 5 7 9
}