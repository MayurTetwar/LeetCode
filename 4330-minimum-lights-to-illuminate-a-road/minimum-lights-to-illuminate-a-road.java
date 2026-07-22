class Solution {
    public int minLights(int[] arr) {
        int n=arr.length;
        int[] map=new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                map[Math.max(0,i-arr[i])]++;
                if(i+arr[i]+1<n)map[i+arr[i]+1]--;
            }
        }
        for(int i=1;i<n;i++){
            map[i]+=map[i-1];
        }
        List<Integer> list=new ArrayList<>();
        int i=0;
        while(i<n){
            int j=i;
            while(j<n && map[j]==0)j++;
            if(i<j)list.add(j-i);
            i=j+1;
        }
        int ans=0;
        for(int num:list){
            ans+=Math.ceilDiv(num,3);
        }
        return ans;
    }
}