class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n==1000000000)return false;
        List<Integer> list=new ArrayList<>();
        int len=0;
        int[] map=new int[10];
        while(n>0){
            map[n%10]++;
            len++;
            n/=10;
        }
        int val=1;
        while(val<Math.pow(10,len)){
            if(val>=Math.pow(10,len-1)){
                list.add(val);
            }
            val*=2;
        }
        for(int num:list){
            int[] curr=new int[10];
            while(num>0){
                curr[num%10]++;
                num/=10;
            }
            boolean pow=true;
            for(int i=0;i<10;i++){
                if(curr[i]!=map[i]){
                    pow=false;
                    break;
                }
            }
            if(pow)return true;
        }
        return false;
    }
}

/*
class Solution {
    boolean flag=true;
    HashMap<Integer,List<Integer>> map=new HashMap<>();
    public void createPair(){
        for(int i=1;i<10;i++){
            map.put(i,new ArrayList<>());
        }
        while(val<Math.pow())
    }
    public boolean reorderedPowerOf2(int n) {
        if(flag){
            flag=false;
            createPair();
        }
        int[] map=new int[10];
        while(n>0){
            map[n%10]++;
            n/=10;
        }
        
        for(int num:list){
            int[] curr=new int[10];
            while(num>0){
                curr[num%10]++;
                num/=10;
            }
            boolean pow=true;
            for(int i=0;i<10;i++){
                if(curr[i]!=map[i]){
                    pow=false;
                    break;
                }
            }
            if(pow)return true;
        }
        return false;
    }
}
*/