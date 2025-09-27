class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> list1=search(s,a);
        List<Integer> list2=search(s,b);
        List<Integer> ans=new ArrayList<>();
        int i=0,j=0;
        while(i<list1.size() && j<list2.size()){
            if(Math.abs(list1.get(i)-list2.get(j))<=k){
                ans.add(list1.get(i));
                i++;
            }else{
                if(list1.get(i)<list2.get(j)){
                    i++;
                }else{
                    j++;
                }
            }
        }
        return ans;
    }
    public List<Integer> search(String te,String pat){
        String com=pat.concat("$").concat(te);
        int[] z=computeZ(com);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<z.length;i++){
            if(z[i]==pat.length()){
                list.add(i-pat.length()-1);
            }
        }
        return list;
    }
    public int[] computeZ(String s){
        int n=s.length();
        int[] z=new int[n];
        int l=0,r=0;
        for(int i=1;i<n;i++){
            if(i<=r){
                z[i]=Math.min(r-i+1,z[i-l]);
            }
            while(i+z[i]<n && s.charAt(z[i])==s.charAt(z[i]+i)){
                z[i]++;
            }
            if(i+z[i]-1>r){
                l=i;
                r=i+z[i]-1;
            }
        }
        return z;
    }
}