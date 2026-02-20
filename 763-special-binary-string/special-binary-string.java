class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list=new ArrayList<>();
        int i=0;
        int count=0;
        int n=s.length();
        for(int j=0;j<n;j++){
            if(s.charAt(j)=='1')count++;
            else count--;
            if(count==0){
                list.add("1".concat(makeLargestSpecial(s.substring(i+1,j))).concat("0"));
                i=j+1;
            }          
        }
        Collections.sort(list,Collections.reverseOrder());
        return String.join("",list);
    }
}