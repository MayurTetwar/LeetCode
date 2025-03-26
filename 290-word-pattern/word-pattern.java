class Solution {
    public boolean wordPattern(String pat, String s) {
        String arr[]=s.split(" ");
        int n=pat.length();
        if(n!=arr.length)return false;
        HashMap<String,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        int i=0;
        for(String str:arr){
            if(map.containsKey(str)){
                if(pat.charAt(i)!=map.get(str))return false;
            }else{
                if(set.contains(pat.charAt(i)))return false;
                map.put(str,pat.charAt(i));
                set.add(pat.charAt(i));
            }
            i++;
        }
        return true;
    }
}