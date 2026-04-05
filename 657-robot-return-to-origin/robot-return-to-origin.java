class Solution {
    public boolean judgeCircle(String moves) {
        int ver=0;
        int hor=0;
        for(char ch:moves.toCharArray()){
            if(ch=='U')hor++;
            else if(ch=='D')hor--;
            else if(ch=='L')ver--;
            else ver++;
        }   
        return (hor==0 && ver==0);
    }
}