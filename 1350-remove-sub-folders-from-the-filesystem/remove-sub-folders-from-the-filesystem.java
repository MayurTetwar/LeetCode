class Solution {
    public List<String> removeSubfolders(String[] arr) {
        List<String> ans=new ArrayList<>();
        Arrays.sort(arr,(a,b)->{
          //  if(a.length()!=b.length())return a.length()-b.length();
            return a.compareTo(b);
        });
        int curr=1;
        ans.add(arr[0]);
        while(curr<arr.length){
            int prev=curr-1;
            while(curr<arr.length && arr[curr].startsWith(arr[prev]) && arr[curr].length()>arr[prev].length() && arr[curr].charAt(arr[prev].length())=='/'){
                curr++;
            }
            if(curr<arr.length)ans.add(arr[curr]);
            curr++;
        }
        return ans;
    }
}