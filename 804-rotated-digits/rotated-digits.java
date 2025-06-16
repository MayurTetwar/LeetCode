class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            String s=String.valueOf(i);
            if(conOne(s) && conTwo(s))count++;
        }
        return count;
    }
    public boolean conOne(String s){
        if(s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9"))return true;
        return false;
    }
    public boolean conTwo(String s){
        if(s.contains("3") || s.contains("4") || s.contains("7"))return false;
        return true;
    }
}