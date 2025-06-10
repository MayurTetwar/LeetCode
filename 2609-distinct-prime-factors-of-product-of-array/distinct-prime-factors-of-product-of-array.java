class Solution {
    public int distinctPrimeFactors(int[] arr) {
        int max=0;
        for(int num:arr){
            max=Math.max(max,num);
        }
        List<Integer> primes=getPrime(max);
        boolean[] visi=new boolean[1001];
        int count=0;
        System.out.println(primes);
        for(int num:arr){
            for(int prime:primes){
                //System.out.println(num+" "+prime);
                //System.out.println(num);
                boolean flag=false;
                while(num%prime==0){
                    num=num/prime;
                    flag=true;
                }
                if(flag){
                    if(!visi[prime])count++;
                    visi[prime]=true;
                }
                if(num<=1 || prime>num)break;
            }
        }
        // for(int i=0;i<1001;i++){
        //     if(visi[i]){
        //         System.out.println(i);
        //     }
        // }
        return count;
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