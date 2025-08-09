class Solution {
    // int decimal = Integer.parseInt(binaryString, 2);
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i+k<=s.length();i++){
            set.add(Integer.parseInt(s.substring(i,i+k),2));
        }
        return set.size()==(1<<k);
    }
}