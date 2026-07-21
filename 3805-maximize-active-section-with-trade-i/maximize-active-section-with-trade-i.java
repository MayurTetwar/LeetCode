class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ans=0;
        int n=s.length();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int j=i;
            while(i<n && s.charAt(i)=='0')i++;
            if(i>j)list.add(i-j);
        }    
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')ans++;
        }
        if(list.size()<2)return ans;
        int max=0;
        for(int i=0;i<list.size()-1;i++){
            max=Math.max(max,list.get(i)+list.get(i+1));
        }
       // System.out.println(ans+" "+max);
        return ans+max;
    }
}