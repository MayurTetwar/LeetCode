class Solution {
    public int getLength(int[] arr) {
        int ans=1;
        int n=arr.length;
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i;j<n;j++){
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
                if(map.size()>1)break;
                ans=Math.max(ans,map.get(arr[j]));
            }
        }
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            int[] count=new int[2002];
            int dis=0;
            for(int j=i;j<n;j++){
                if(map.containsKey(arr[j])){
                    int val=map.get(arr[j]);
                    if(count[val]==1)dis--;
                    count[val]--;
                    val++;
                    if(count[val]==0)dis++;
                    count[val]++;
                    map.put(arr[j],val);
                }else{
                    if(count[1]==0)dis++;
                    count[1]++;
                    map.put(arr[j],1);
                }
                // System.out.println(i+" "+j+" "+map+" "+dis);
                if(dis==2){
                    int val=map.get(arr[i]);
                    if(val%2==0 && count[val/2]>0){
                        ans=Math.max(ans,count[val]*val+count[val/2]*(val/2));
                    }
                    if(count[val*2]>0){
                        ans=Math.max(ans,count[val]*val+count[val*2]*val*2);
                    }
                }
            }
        }
        return ans;
    }
}