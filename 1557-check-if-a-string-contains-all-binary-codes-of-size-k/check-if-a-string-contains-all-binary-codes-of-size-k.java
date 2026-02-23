class Solution {
    // int decimal = Integer.parseInt(binaryString, 2);
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> set=new HashSet<>();
        int val=0;
        for(int i=0;i<k && i<s.length();i++){
            val=val<<1;
            if(s.charAt(i)=='1')
                val=val|1;
        }
        for(int i=k;i<s.length();i++){
            set.add(val);
            if(s.charAt(i-k)=='1'){
                val=val&(~(1<<(k-1)));
            }
            val=val<<1;
            if(s.charAt(i)=='1'){
                val=val|1;
            }
        }
        set.add(val);
        return set.size()==(1<<k);
    }
}