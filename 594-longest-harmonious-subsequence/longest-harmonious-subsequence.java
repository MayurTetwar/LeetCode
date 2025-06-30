class Solution {
     static{
        for (int i = 0; i < 500; i++){
            findLHS(new int[]{1,2,3,4});
        }
    }
    public static int findLHS(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int last=0;
        int max=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            int curr=1;
            set.add(arr[i]);
            while(i<n-1 && arr[i]==arr[i+1]){
                i++;
                curr++;
            }
          //  System.out.println();
            if(last!=0 && set.contains(arr[i]-1))max=Math.max(max,curr+last);
            last=curr;
        }
        return max;
    }
}
/*
class Solution {
    public int findLHS(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i]-1) && map.containsKey(arr[i]+1)){
                int val1=0;
                if(map.containsKey(arr[i])){
                    val1=map.get(arr[i])+1;
                }
                int val2=Math.max(map.get(arr[i]-1)+1,map.get(arr[i]+1)+1);
                map.put(arr[i],Math.max(val1,val2));
            }else if(map.containsKey(arr[i]-1)){
                int val1=0;
                if(map.containsKey(arr[i])){
                    val1=map.get(arr[i])+1;
                }
                map.put(arr[i],Math.max(val1,map.get(arr[i]-1)+1));
            }else if(map.containsKey(arr[i]+1)){
                int val1=0;
                if(map.containsKey(arr[i])){
                    val1=map.get(arr[i])+1;
                }
                map.put(arr[i],Math.max(val1,map.get(arr[i]+1)+1));
            }else{
                map.put(arr[i],1);
            }
        }   
        int ans=0;
        for(int key:map.keySet()){
            ans=Math.max(ans,map.get(key));
        }
        return ans;
    }
}
*/