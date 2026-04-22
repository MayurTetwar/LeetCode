class Solution {
    public List<String> twoEditWords(String[] que, String[] dic) {
        List<String> ans=new ArrayList<>();
        int n=que.length;
        int m=dic.length;
        
        for(String q:que){
            for(String s:dic){
                int diff=0;
                for(int i=0;i<s.length();i++){
                    if(q.charAt(i)!=s.charAt(i))diff++;
                    if(diff>2)break;
                }
                if(diff<3){
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }
}