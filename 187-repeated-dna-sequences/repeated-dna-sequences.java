class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        for(int i=0;(i+10)<=s.length();i++){
            String str=s.substring(i,i+10);
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(String str:map.keySet()){
            if(map.get(str)>1)list.add(str);
        }
        return list;
    }
}