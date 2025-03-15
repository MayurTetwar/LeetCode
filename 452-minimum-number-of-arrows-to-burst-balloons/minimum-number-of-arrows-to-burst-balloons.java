class Solution {
    public int findMinArrowShots(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[0]<b[0])return -1;
            return 1;
        });
        // for(int i=0;i<n;i++){
        //     System.out.print(Arrays.toString(arr[i]));
        // }
        // List<int[]> list=new ArrayList<>();
        int start=0;
        int count=0;
        int end=arr[0][1];
        //System.out.println(arr[0][1]);
        for(int i=1;i<n;i++){
            if(end<arr[i][0]){
                // list.add(new int[]{arr[start][0],Math.max(end,arr[start][1])});
                count++;
                start=i;
                end=arr[i][1];
            }
            end=Math.min(end,arr[i][1]);
        }
        // list.add(new int[]{arr[start][0],Math.max(end,arr[start][1])});
        // System.out.println();
        // for(int i=0;i<list.size();i++){
        //     System.out.print(Arrays.toString(list.get(i)));
        // }
        //return list.size();
        return count+1;
    }
}