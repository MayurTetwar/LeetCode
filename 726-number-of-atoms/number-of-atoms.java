class Solution {
    public String countOfAtoms(String f) {
        int n=f.length();
        int[] dp=new int[n+1];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            if(f.charAt(i)=='('){
                stk.push(i);
            }else if(f.charAt(i)==')'){
                int x=stk.pop();
                dp[x]=i;
               // System.out.println(x+" "+i);
            }
        }
       // dp[0]=n;
        HashMap<String,Integer> map=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     if(dp[i]>0){
                // System.out.println(Arrays.toString(dp));
                helper(map,0,n-1,1,f,dp);
        //         i=dp[i];
        //     }
        // }
        // Sort the final map
        TreeMap<String, Integer> finalMap = new TreeMap<>(map);
        //System.out.println(finalMap);
        StringBuilder ans=new StringBuilder();
        for(String x:finalMap.keySet()){
            ans.append(x);
            if(map.get(x)>1)ans.append(map.get(x));
        }
        return ans.toString();
    }
    public void helper(HashMap<String,Integer> map,int st,int end,int add,String f,int[] dp){
        StringBuilder sb=new StringBuilder();
       // int i=0;
        while(st<=end){
            if('A'<=f.charAt(st) && f.charAt(st)<='Z'){
                sb.append(f.charAt(st++));
                while(st<=end && f.charAt(st)>='a' && f.charAt(st)<='z'){
                    sb.append(f.charAt(st++));
                }
                int val=0;
                while(st<=end  && '0'<=f.charAt(st) && f.charAt(st)<='9'){
                    val*=10;
                    val+=f.charAt(st++)-'0';
                }
                val=(val==0)?1:val;
                String x=sb.toString();
               // System.out.println(x+" "+val+" "+add);
                map.put(x,map.getOrDefault(x,0)+val*add);
                sb=new StringBuilder();
            }else if('('==f.charAt(st)){
                int newst=st+1;
                int newend=dp[st]-1;
                int curr=dp[st]+1;
                int val=0;
                dp[st]=0;
                while(curr<f.length() && '0'<=f.charAt(curr) && f.charAt(curr)<='9'){
                    val*=10;
                    val+=f.charAt(curr)-'0';
                    curr++;
                }
                //curr++;
                val=(val==0)?1:val;
               // System.out.println(f.charAt(newst)+" "+newst+" "+newend+" "+val);
                helper(map,newst,newend,val*add,f,dp);
                st=curr;
            }
            // if(st<f.length()){
            //     System.out.println(st+" "+end);
            // }
            // i++;
            // if(i>30)break;
        }
    }
}