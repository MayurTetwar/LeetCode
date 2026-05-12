class Solution {
    public int[] getSubarrayBeauty(int[] arr, int k, int x) {
        int[] map=new int[101];
        for(int i=0;i<k-1;i++){
            map[arr[i]+50]++;
        }
        int n=arr.length;
        int[] ans=new int[n-k+1];
        for(int i=k-1;i<n;i++){
            map[arr[i]+50]++;
            // List<Integer> list=new ArrayList<>();
            // for(int min=-50;min<=50;min++){
            //     if(map[min+50]>0){
            //         list.add(min);
            //     }
            // }
            // System.out.println(list);
            int temp=x;
            for(int min=-50;min<=0;min++){
                temp-=map[min+50];
                if(temp<=0){
                    ans[i-k+1]=min;
                    break;
                }
            }
            map[arr[i-k+1]+50]--;
        }
        return ans;
    }
}