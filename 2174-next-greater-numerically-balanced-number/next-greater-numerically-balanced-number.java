class Solution {
    public int nextBeautifulNumber(int n) {
        int ans=n+1;
        while(true){
            int[] cnt=new int[10];
            n=ans;
                // System.out.println(ans);

            while(n>0){
                cnt[n%10]++;
                n/=10;
                // System.out.println(n);
            }
            boolean flag=true;
            if(cnt[0]>0){
                ans++;
                continue;
            }
            for(int i=1;i<10;i++){
                if(cnt[i]>0 && cnt[i]!=i){
                    flag=false;
                    break;
                }
            }
            if(flag)return ans;
            ans++;

        }
        // return -1;
    }
}