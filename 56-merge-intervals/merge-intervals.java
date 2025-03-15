class Solution {
    public int[][] merge(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        // for(int i=0;i<n;i++){
        //     System.out.print(Arrays.toString(arr[i]));
        // }
        List<int[]> list=new ArrayList<>();
        int start=0;
        int end=arr[0][1];
        for(int i=1;i<n;i++){
            if(end<arr[i][0]){
                list.add(new int[]{arr[start][0],Math.max(end,arr[start][1])});
                start=i;
            }
            end=Math.max(end,arr[i][1]);
        }
        list.add(new int[]{arr[start][0],Math.max(end,arr[start][1])});
        int[][] ans=new int[list.size()][2];
        int i=0;
        for(int[] a:list){
            ans[i][0]=a[0];
            ans[i++][1]=a[1];
        }
        return ans;
    }
}