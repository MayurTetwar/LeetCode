class Solution {
    public String makeFancyString(String s) {
        if(s.length()<=2)return s;
        StringBuilder sb=new StringBuilder();
        int i=0;
        sb.append(s.charAt(0));
        for(i=1;i<s.length()-1;i++){
            if(!(s.charAt(i-1)==s.charAt(i) && s.charAt(i)==s.charAt(i+1))){
                sb.append(s.charAt(i));
            }
        }
        sb.append(s.charAt(i));
        return sb.toString();
    }
}