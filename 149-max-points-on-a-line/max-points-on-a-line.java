class Solution {
    public int maxPoints(int[][] arr) {
        int n=arr.length;
        int ans=1;
        for(int i=0;i<n;i++){
            HashMap<Double,Integer> map=new HashMap<>();
            for(int j=i+1;j<n;j++){
                double num=arr[i][0]-arr[j][0];
                double deno=arr[i][1]-arr[j][1];
                double val=0;
                if(num==0){
                    val=50001;
                }else if(deno==0){
                    val=-50001;
                }else{
                    val=num/deno;
                }
                if(map.containsKey(val)){
                    map.put(val,map.get(val)+1);
                }else{
                    map.put(val,2);
                }
                ans=Math.max(ans,map.get(val));
            }
        }
        return ans;
    }
}