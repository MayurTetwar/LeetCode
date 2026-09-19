class Solution {
    public int longestAwesome(String s) {
        int n=s.length();
        HashMap<Long,Integer> map=new HashMap<>();
        long mask=0;
        int res=0;
        map.put(0L,-1);
        for(int i=0;i<n;i++){
            mask=mask^(1<<(s.charAt(i)-'0'));
            if(map.containsKey(mask)){
                res=Math.max(res,i-map.get(mask));
            }else{
                map.put(mask,i);
            }
            for(int bit=0;bit<10;bit++){
                long pmask=mask ^ (1<<bit);
                if(map.containsKey(pmask)){
                    res=Math.max(res,i-map.get(pmask));
                }
                // System.out.println(res+" "+i+"\n ------------- \n");
            }
        }
        return res;
    }
}