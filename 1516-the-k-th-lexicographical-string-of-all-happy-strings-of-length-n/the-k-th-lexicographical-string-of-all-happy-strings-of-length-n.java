class Solution {
    public String getHappyString(int n, int k) {
        List<String> list=new ArrayList<>();
        helper(list,new StringBuilder(),n,'m',k);
        //System.out.println(list);
        if(k<=list.size())return list.get(k-1);
        return "";
    }
    public int helper(List<String> list,StringBuilder ans,int n,char ch,int k){
        //System.out.println(ch);
        if(k<0)return k;
        if(n<=0){
            String add=ans.toString();
            list.add(add);
            k--;
            return k;
        }
        if(ch!='a'){
            ans.append('a');
            k=helper(list,ans,n-1,'a',k);
            //System.out.println(list);
            ans.deleteCharAt(ans.length()-1);
        }
        if(ch!='b'){
            ans.append('b');
            k=helper(list,ans,n-1,'b',k);
            //System.out.println(list);

            ans.deleteCharAt(ans.length()-1);
        }
        if(ch!='c'){
            ans.append('c');
            k=helper(list,ans,n-1,'c',k);
            //System.out.println(list);

            ans.deleteCharAt(ans.length()-1);
        }
        return k;
    }
}