class WordFilter {
    HashMap<String,HashMap<String,Integer>> map;
    public WordFilter(String[] arr) {
        map=new HashMap<>();
        int n=arr.length;
        int k=0;
        for(String str:arr){
            int len=str.length();
            for(int i=1;i<=len;i++){
                HashMap<String,Integer> map2=new HashMap<>();
                String pref=str.substring(0,i);
                for(int j=0;j<=len;j++){
                    map2.put(str.substring(j,len),k);
                }
                if(map.containsKey(pref)){
                    HashMap<String,Integer> map3=map.get(pref);
                    for(String s:map2.keySet()){
                        if(map3.containsKey(s)){
                            int ind=map3.get(s);
                            int ind2=map2.get(s);
                            map3.put(s,Math.max(ind,ind2));
                        }else{
                            map3.put(s,map2.get(s));
                        }
                    }
                    map.put(pref,map3);
                }else{
                    map.put(pref,map2);
                }
            }
            k++;
        }
     //  System.out.println(map);
    }
    
    public int f(String pref, String suff) {
        if(map.containsKey(pref)){
            if(map.get(pref).containsKey(suff)){
                return map.get(pref).get(suff); 
            }
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */