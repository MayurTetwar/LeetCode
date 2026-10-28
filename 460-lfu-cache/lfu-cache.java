class LFUCache {
    int capacity;
    int lowfre;
    HashMap<Integer,Node> map;          
    HashMap<Integer,Link> linkmap;
    class Node{
        Node prev,next;
        int key,count,val;
        Node(int key,int val){
            this.key=key;
            this.val=val;
            count=0;
        }
    }
    class Link{
        Node first,last;
        int size;
        Link(){
            first=new Node(-1,-1);
            last=new Node(-1,-1);
            first.next=last;
            last.prev=first;
            size=0;
        }
    }
    public LFUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        linkmap=new HashMap<>();
        lowfre=0;
    }
    public void delete(Node node,int count){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        Link link=linkmap.get(count);
        link.size--;
        if(link.size==0 && lowfre==count){
            lowfre++;
            linkmap.remove(count);
        }
        map.remove(node.key);
    }
    public void insert(Node node,int count){
        Link link=linkmap.getOrDefault(count,new Link());
        Node last=link.last;
        node.next=last;
        node.prev=last.prev;
        last.prev.next=node;
        last.prev=node;
        link.size++;
        if(count==1)lowfre=1;
        linkmap.put(count,link);
        map.put(node.key,node);
    }

    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node node=map.get(key);
        delete(node,node.count);
        node.count++;
        insert(node,node.count);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value; 
            get(key);
            return;
        }
        Node node=new Node(key,value);
        if(map.size()==capacity){
            Link link=linkmap.get(lowfre);
            Node temp=link.first.next;
            delete(temp,temp.count);
        }
        node.count++;
        insert(node,node.count);
        // System.out.println(key+" "+map+" "+linkmap);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */