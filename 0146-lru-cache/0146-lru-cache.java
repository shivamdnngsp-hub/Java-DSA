class LRUCache {

    class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


   Map<Integer,ListNode> mpp;
   int capacity;
   ListNode head;
   ListNode tail;

   public void delete(ListNode node){
    node.prev.next = node.next;
    node.next.prev = node.prev;
   }
public void add(ListNode node){
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
}


    public LRUCache(int capacity) {
        this.capacity = capacity;
        mpp = new HashMap<>();
        head = new ListNode(-1,-1);
        tail =  new ListNode(-1,-1);
       head.next = tail;
       tail.prev = head;
    }

    
    public int get(int key) {
      if(mpp.containsKey(key)){
        ListNode n = mpp.get(key);
        delete(n);
        add(n);
        return n.value;
      }
      return -1;
    }
    
    public void put(int key, int value) {
       if (mpp.containsKey(key)){
            ListNode node = mpp.get(key);
            node.value = value;
            delete(node);
            add(node);
            return;
        }

        if(mpp.size() == capacity){
            ListNode lru = tail.prev;
            delete(lru);
            mpp.remove(lru.key);
        }
         ListNode n = new ListNode(key, value);

        add(n);
        mpp.put(key, n);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */