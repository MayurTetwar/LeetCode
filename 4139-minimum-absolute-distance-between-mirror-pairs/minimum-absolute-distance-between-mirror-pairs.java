class Solution {
    public int minMirrorPairDistance(int[] arr) {
        int n=arr.length;
        int[] rev=new int[n];
        for(int i=0;i<n;i++){
            int curr=arr[i];
            int val=0;
            while(curr>0){
                val=val*10+(curr%10);
                curr/=10;
            }
            rev[i]=val;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int min=n;
        for(int i=0;i<n;i++){
            // System.out.println(rev[i]);
            if(map.containsKey(arr[i])){
                min=Math.min(min,i-map.get(arr[i]));
            }
            map.put(rev[i],i);
        }
        return (min==n)?-1:min;
    }
}