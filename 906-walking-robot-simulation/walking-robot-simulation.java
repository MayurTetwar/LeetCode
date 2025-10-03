class Solution {
    public int robotSim(int[] arr, int[][] ob) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int[] a:ob){
            if(!map.containsKey(a[0])){
                map.put(a[0],new HashSet<>());
            }
            map.get(a[0]).add(a[1]);
        }
        int ans=0;
        int i=0,j=0;
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int d=0;
        int n=arr.length;
        for(int k=0;k<n;k++){
            if(arr[k]==-1){
                d++;
                d=d%4;
            }else if(arr[k]==-2){
                d--;
                if(d<0)d=3;
            }else{
                while(arr[k]>0){
                    i=i+dir[d][0];
                    j=j+dir[d][1];
                    if(map.containsKey(i) && map.get(i).contains(j)){
                        i=i-dir[d][0];
                        j=j-dir[d][1];
                        break;
                    }
                        // System.out.println(i+" "+j);
                    arr[k]--;
                }
                ans=Math.max(ans,i*i+j*j);
            }
        }
        return ans;
    }
}