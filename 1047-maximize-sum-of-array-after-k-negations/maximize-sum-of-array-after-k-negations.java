class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr);
        int ans=0;
        int n=arr.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                if(k>0){
                    k--;
                    ans-=arr[i];
                    list.add(-arr[i]);
                }else{
                    ans+=arr[i];
                    list.add(arr[i]);
                }
            }else{
                if(k>=2){
                    k-=2;
                }
                ans+=arr[i];
                list.add(arr[i]);
            }
        }
        if(k==0)return ans;
        Collections.sort(list);
        return ans-2*list.get(0);
    }
}