class Solution {
    public int countDays(int days, int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[0]<b[0])return -1;
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return 1;
        });
        List<int[]> list=new ArrayList<>();
        int start=0;
        int end=0;
        for(int i=1;i<n;i++){
          //  System.out.println(arr[i][0]+" "+arr[i][1]);
            if(arr[end][1]<arr[i][0]){
                list.add(new int[]{arr[start][0],arr[end][1]});
                start=i;
            }
            end=(arr[end][1]>arr[i][1])?end:i;
        }
        list.add(new int[]{arr[start][0],arr[end][1]});
        int ans=days;
        for(int a[]:list){
         //   System.out.println(ans+" "+a[1]+" "+a[0]);
            ans-=(a[1]-a[0])+1;
        }
        return ans;
    }
}