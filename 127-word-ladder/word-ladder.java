class Solution {
    class Node{
        String s;
        int count;
        Node(String s,int count){
            this.s=s;
            this.count=count;
        }
    }
    public int ladderLength(String st, String end, List<String> list) {
        int n=list.size();
        int ans=0;

        Queue<Node> q=new LinkedList<>();
        q.add(new Node(st,1));
        boolean[] visi=new boolean[n];

        while(!q.isEmpty()){
            Node curr=q.poll();
            if(end.equals(curr.s)){
                ans=curr.count;
                break;
            }
            int i=0;
            for(String s:list){
                if(same(s,curr.s) && !visi[i]){
                    visi[i]=true;
                    q.add(new Node(s,curr.count+1));
                }
                i++;
            }
        }
        return ans;
    }
   
    public boolean same(String a,String b){
        int n=a.length();
        int count=0;
        for(int i=0;i<n;i++){
            if(a.charAt(i)==b.charAt(i))count++;
        }
        return count==n-1;
    }
}