class Solution {
    public int sumFourDivisors(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            List<Integer> divisors=findDivisors(arr[i]);
            if(divisors.size()==4){
                sum+=divisors.get(0)+divisors.get(1)+divisors.get(2)+divisors.get(3);
            }
        }
        return sum;   
    }
    public static List<Integer> findDivisors(int x) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                divisors.add(i);
                if (i != x / i) {
                    divisors.add(x / i);
                }
            }
        }
        return divisors;
    }
}