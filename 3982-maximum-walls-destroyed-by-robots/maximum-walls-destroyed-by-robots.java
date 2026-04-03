class Solution {
    Integer[][] memo;
    public int maxWalls(int[] arr, int[] dis, int[] wall) {
        int n=arr.length;
        int m=wall.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] num=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],dis[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(wall);
        for(int i=0;i<n;i++){
            int pos1=bs2(wall,arr[i]);
            int lp=0;
            if(i>0){
                lp=bs1(wall,Math.max(arr[i]-map.get(arr[i]),arr[i-1]+1));
            }else{
                lp=bs1(wall,arr[i]-map.get(arr[i]));
            }
            left[i]=pos1-lp;
            
            int pos2=bs1(wall,arr[i]);
            int rp=0;
            if(i<n-1){
                rp=bs2(wall,Math.min(arr[i]+map.get(arr[i]),arr[i+1]-1));
            }else{
                rp=bs2(wall,arr[i]+map.get(arr[i]));
            }
            right[i]=rp-pos2;
            if(i==0)continue;
            int pos3=bs1(wall,arr[i-1]);
            num[i]=pos1-pos3;
        }
        // System.out.println(Arrays.toString(right));
        // System.out.println(Arrays.toString(left));
        memo=new Integer[n][2];
        int res1=helper(left,right,num,0,0);
        memo=new Integer[n][2];
        int res2=helper(left,right,num,0,1);
        return Math.max(res1,res2);
    }
    public int helper(int[] left,int[] right,int[] num,int i,int isleft){
        if(i==num.length)return 0;
        if(memo[i][isleft]!=null)return memo[i][isleft];
        int res=0;
        if(isleft==1){
            int res1=helper(left,right,num,i+1,1)+left[i];
            int res2=helper(left,right,num,i+1,0)+right[i];
            res=Math.max(res1,res2);
        }else{
            int res1=helper(left,right,num,i+1,1);
            int res2=helper(left,right,num,i+1,0)+right[i];
            if(i==0){
                res1+=left[i];
            }else{
                res1+=Math.min(left[i],num[i]-right[i-1]);
            }
            res=Math.max(res1,res2);
        }
        return memo[i][isleft]=res;
    }
    public int bs1(int[] arr,int tar){
        int st=0;
        int end=arr.length;
        while(st<end){
            int mid=(st+end)/2;
            if(arr[mid]<tar){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        return st;
    }
    public int bs2(int[] arr,int tar){
        int st=0;
        int end=arr.length;
        while(st<end){
            int mid=(st+end)/2;
            if(arr[mid]<=tar){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        return st;
    }
   
}