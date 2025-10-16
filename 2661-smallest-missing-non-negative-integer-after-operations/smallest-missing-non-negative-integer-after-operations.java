class Solution {
    public int findSmallestInteger(int[] arr, int value) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            if(num<0)num=value+(num%value);
            map.put(num%value,map.getOrDefault(num%value,0)+1);
        }
        // System.out.println(map);
        int mex=0;
        while(map.containsKey(mex%value)){
            int cnt=map.get(mex%value);
            if(cnt==0)break;
            map.put(mex%value,cnt-1);
            mex++;
        }
        return mex;
    }
}