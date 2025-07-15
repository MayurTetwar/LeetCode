class Solution {
    public boolean isValid(String word) {
        boolean isVo=false;
        boolean isCon=false;
        for(char ch:word.toLowerCase().toCharArray()){
            if((ch>='a' && ch<='z')){
                if('a'==ch || 'e'==ch || 'i'==ch || 'o'==ch || 'u'==ch){
                    isVo=true;
                }else{
                    isCon=true;
                }
            }else if(ch>'9' || ch<'0'){
                    return false;
            }
        }
        return (word.length()>=3 && isVo && isCon);
    }
}