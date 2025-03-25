class Solution {
    int count;
    public int totalNQueens(int n) {
        count=0;
    helper(0,n,new HashSet<>(),new HashSet<>(),new HashSet<>());
        return count;
    }
    public void helper(int i,int n,HashSet<Integer> set,HashSet<Integer> s1,HashSet<Integer> s2){
       // System.out.println(set+" "+s1+" "+s2);
        if(n==i){
            count++;
            return;
        }
        for(int j=0;j<n;j++){
            if(!set.contains(j-i) && !s1.contains(j+i) && !s2.contains(j)){
                set.add(j-i);
                s1.add(j+i);
                s2.add(j);
                helper(i+1,n,set,s1,s2);
                set.remove(j-i);
                s1.remove(j+i);
                s2.remove(j);
            }
        }
        return ;
    }
}