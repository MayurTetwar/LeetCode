class Solution {
    public int maxTwoEvents(int[][] arr) {
        int n=arr.length;
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new int[]{arr[i][0],1,arr[i][2]});
            list.add(new int[]{arr[i][1]+1,2,arr[i][2]});
        }
        list.sort((a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return b[1]-a[1];
        });
        int curr=0;
        int max=-1;
        for(int[] a:list){
            if(a[1]==1){
                max=Math.max(max,curr+a[2]);
            }else{
                curr=Math.max(curr,a[2]);
            }
        }
        return max;
    }
}