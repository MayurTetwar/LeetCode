class Solution {
    long MOD=(long)1e9+7;
    public int maximumScore(List<Integer> list, int k) {
        int n=list.size();

        int[] s=new int[n];
        int max=Collections.max(list);
        List<Integer> primes=getPrime(max);

        for(int i=0;i<n;i++){
            int num=list.get(i);
            for(int p:primes){
                if(p*p>num)break;
                if(num%p!=0)continue;
                s[i]++;
                while(num%p==0)num/=p;
            }
            if(num>1)s[i]++;
        }
        
        int[] next=new int[n];
        int[] prev=new int[n];
        Arrays.fill(next,n);
        Arrays.fill(prev,-1);

        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && s[stk.peek()]<s[i]){
                int top=stk.pop();
                next[top]=i;
            }
            if(!stk.isEmpty()){
                prev[i]=stk.peek();
            }
            stk.push(i);
        }
        long[] numOfSub=new long[n];
        for(int i=0;i<n;i++){
            numOfSub[i]=(long)(next[i]-i)*(i-prev[i]);
        }
        List<int[]> sortlist=new ArrayList<>();
        for(int i=0;i<n;i++){
            sortlist.add(new int[]{list.get(i),i});
        }
        sortlist.sort((a,b)->Integer.compare(b[0],a[0]));
        long ans=1;
        int i=0;
        //System.out.println(Arrays.toString(numOfSub));
        while(k>0){
            int[] numind=sortlist.get(i++);
            int num=numind[0];
            int ind=numind[1];
            long op=Math.min(k,numOfSub[ind]);
            ans=(ans*power(num,op))%MOD;
            k-=op;
        }
        return (int)ans;
    }
    public long power(long a,long b){
        long ans=1;
        while(b>0){
            if(b%2==1){
                ans=(ans*a)%MOD;
            }
            a=(a*a)%MOD;
            b/=2;
        }
        return ans;
    }
    public List<Integer> getPrime(int num){
        List<Integer> list=new ArrayList<>();
        boolean[] visi=new boolean[num+1];
        for(int i=2;i<=num;i++){
            if(!visi[i]){
                list.add(i);
                for(long j=(long)i*i;j<=num;j+=i){
                    visi[(int)j]=true;
                }
            }
        }   
        return list;
    }
}