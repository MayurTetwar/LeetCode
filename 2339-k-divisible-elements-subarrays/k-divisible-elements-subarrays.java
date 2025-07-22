class Solution {
    public int countDistinct(int[] arr, int k, int p) {
        Set<String> set=new HashSet<>();
        int n=arr.length;
        int ans=0;
        int[] count=new int[n];
        if(arr[0]%p==0)count[0]++;
        for(int i=1;i<n;i++){
            if(arr[i]%p==0)count[i]++;
            count[i]+=count[i-1];
        }
        //System.out.println(Arrays.toString(count));
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<n;j++){
                if (j>i) {
                    sb.append(",");
                }
                sb.append(arr[j]);
                if(set.contains(sb.toString()))continue;
                set.add(sb.toString());
                if(i==0 && count[j]>k)break;
                if(i>=1 && count[j]-count[i-1]>k)break;
                ans++;
            }
            //System.out.print(ans+" ");
            // for(String s:set){
            //     //System.out.print(s+"|");
            // }
            //System.out.println();
        }
        return ans;
    }
    /*
    [2], [2,3], [2,3,3], [2,3,3,2], [3], [3,3], [3,3,2], [3,3,2,2], [3,2], [3,2,2], and [2,2]
    |2,3,3,2,2|3,2,2|
    */
}