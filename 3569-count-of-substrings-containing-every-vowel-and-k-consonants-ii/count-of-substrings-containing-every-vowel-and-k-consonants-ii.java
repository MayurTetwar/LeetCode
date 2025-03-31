class Solution {
    public long countOfSubstrings(String s, int k) {
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0,right=0;
        int ccon=0;
        int n=s.length();
        long ans=0;
        int[] next=new int[n];
        int last=n;
        for(int i=n-1;i>=0;i--){
            next[i]=last;
            if(!set.contains(s.charAt(i))){
                last=i;
            }
        }
        //System.out.println(Arrays.toString(next));
        while(right<n){
            char ch=s.charAt(right);
            if(set.contains(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }else ccon++;
            while(ccon>k){
                char leftch=s.charAt(left);
                if(set.contains(leftch)){
                    map.put(leftch,map.get(leftch)-1);
                    if(map.get(leftch)==0){
                        map.remove(leftch);
                    }
                }else ccon--;
                left++;
            }
            while(left<n && map.keySet().size()==5 && ccon==k){
                ans+=next[right]-right;
                char leftch=s.charAt(left);
                 if(set.contains(leftch)){
                    map.put(leftch,map.get(leftch)-1);
                    if(map.get(leftch)==0){
                        map.remove(leftch);
                    }
                }else ccon--;
                left++;
            }
            right++;
        }
        return ans;
    }
}