class Solution {
    public String smallestSubsequence(String s) {
        int[] count=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        Stack<Character> stk=new Stack<>();
        boolean[] visi=new boolean[27];
        for(char ch:s.toCharArray()){
            while(!stk.isEmpty() && stk.peek()>=ch && count[stk.peek()-'a']>0 && !visi[ch-'a']){
                visi[stk.pop()-'a']=false;
            }
            if(!visi[ch-'a'])stk.add(ch);
            visi[ch-'a']=true;
            count[ch-'a']--;
            // System.out.println(stk);
        }
        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}