class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int a = 0;
        int sum = 0;
        for(int i=0;i<requests.length;i++){
            sum+=Math.abs(a-requests[i]);
            a=requests[i];
        }
        return sum;
    }
}