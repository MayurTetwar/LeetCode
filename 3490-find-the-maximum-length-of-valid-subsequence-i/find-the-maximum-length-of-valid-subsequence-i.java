class Solution {
    int[][] memo;
    public int maximumLength(int[] arr) {
        memo=new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            memo[i][0]=-1;
            memo[i][1]=-1;
        }
        int len1=helperOne(arr,0,true);
        int len2=helperOne(arr,0,false);
        memo=new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            memo[i][0]=-1;
            memo[i][1]=-1;
        }
        int len3=helperZero(arr,0,true);
        int len4=helperZero(arr,0,false);
        return Math.max(Math.max(len1,len2),Math.max(len3,len4));
    }
    
    public int helperZero(int[] arr,int i,boolean odd){
        if(i==arr.length)return 0;
        if(memo[i][(odd)?0:1]!=-1)return memo[i][(odd)?0:1]; 
        int len1=helperZero(arr,i+1,odd);
        int len2=0;
        if(odd){
            if(arr[i]%2!=0){
                len2=helperZero(arr,i+1,odd)+1;
            }
        }else{
             if(arr[i]%2==0){
                len2=helperZero(arr,i+1,odd)+1;
            }
        }
        return memo[i][(odd)?0:1]=Math.max(len1,len2);
    }
    public int helperOne(int[] arr,int i,boolean odd){
        if(i==arr.length)return 0;
        if(memo[i][(odd)?0:1]!=-1)return memo[i][(odd)?0:1];
        int len1=helperOne(arr,i+1,odd);
        int len2=0;
        if(odd){
            if(arr[i]%2==0){
                len2=helperOne(arr,i+1,false)+1;
            }
        }else{
             if(arr[i]%2!=0){
                len2=helperOne(arr,i+1,true)+1;
            }
        }
        return memo[i][(odd)?0:1]=Math.max(len1,len2);
    }
}