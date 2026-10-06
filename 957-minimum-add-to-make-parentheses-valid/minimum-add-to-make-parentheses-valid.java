class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        int closecount=0;
        char[] charArray=s.toCharArray();
        for(char ch:charArray){
            if(ch=='('){
                count++;
            }else{
                if(count>0){
                    count--;
                }else{
                    closecount++;
                }
            }
        }
        return count+closecount;
    }
}