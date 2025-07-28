class Solution {
    int ans;
    int max;
    public int countMaxOrSubsets(int[] arr) {
        int n=arr.length;
        max=0;
        ans=0;
        maxOr(arr,0,0);
        ansOr(arr,0,0);
        return ans;
    }
    public void maxOr(int[] arr,int i,int val){
        if(i==arr.length){
            max=Math.max(max,val);
            return;
        }
        maxOr(arr,i+1,val);
        maxOr(arr,i+1,val|arr[i]);
    }
    public void ansOr(int[] arr,int i,int val){
        if(i==arr.length){
            if(max==val)ans++;
            return;
        }
        ansOr(arr,i+1,val);
        ansOr(arr,i+1,val|arr[i]);
    }
}