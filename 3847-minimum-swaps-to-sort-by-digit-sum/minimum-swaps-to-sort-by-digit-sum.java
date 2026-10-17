class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(ar1,ar2)->{
            int sum1=0,sum2=0;
            int a=ar1[0];
            int b=ar2[0];
            while(a>0){
                sum1+=a%10;
                a/=10;
            }
            while(b>0){
                sum2+=b%10;
                b/=10;
            }
            if(sum1==sum2)return ar1[0]-ar2[0];
            return sum1-sum2;
        });
        int ans=0;
        boolean[] visi=new boolean[n];
        for(int i=0;i<n;i++){
            if(visi[i])continue;
            int curr=i;
            int count=0;
            while(!visi[curr]){
                visi[curr]=true;
                curr=arr[curr][1];
                // System.out.println(curr+" "+count);
                count++;
            }
            ans+=count-1;
        }
        return ans;
    }
}