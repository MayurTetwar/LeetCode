class Solution {
    public int minimumOperations(int[] arr) {
        int[] map=new int[101];
        int dup=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            map[arr[i]]++;
            if(map[arr[i]]>1){
                dup++;
            }
        }
        int ans=0;
        int i=0;
        int len=n;
        while(dup!=0){
            //System.out.println(dup+" "+n);
            for(int j=i;j<len && j<i+3;j++){
                if(map[arr[j]]>1)dup--;
                map[arr[j]]--;
            }
            i+=3;
            n-=3;
            ans++;
        }
        return ans;
    }
}