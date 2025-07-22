class Solution {
    public int countDistinct(int[] arr, int k, int p) {
        Set<String> set=new HashSet<>();
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int count=0;
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<n;j++){
                if(arr[j]%p==0)count++;
                if(count>k)break;
                sb.append(arr[j]).append(",");
                set.add(sb.toString());
            }
        }
        return set.size();
    }
    /*
    [2], [2,3], [2,3,3], [2,3,3,2], [3], [3,3], [3,3,2], [3,3,2,2], [3,2], [3,2,2], and [2,2]
    |2,3,3,2,2|3,2,2|
    */
}