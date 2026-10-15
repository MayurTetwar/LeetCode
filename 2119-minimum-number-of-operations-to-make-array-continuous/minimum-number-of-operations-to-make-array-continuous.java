class Solution {
    public int minOperations(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0;
        int ans=n;
        while(i<n){
            while(j<n && arr[j]<=arr[i]+n-1){
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
                j++;
            }
            if(j-i<=map.size())
                ans=Math.min(ans,n-j+i);
            else 
                ans=Math.min(ans,n-map.size());
            // System.out.println(map+" "+i+" "+j+" "+ans);
            int val=map.get(arr[i])-1;
            if(val==0)map.remove(arr[i]);
            else map.put(arr[i],val);
            i++;
        }
        return ans;
    }
}
// 4 5 8 8 9 9 