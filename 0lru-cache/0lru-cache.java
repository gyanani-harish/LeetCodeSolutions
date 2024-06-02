class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;//only for help, not a real value
    Node tail;//only for help, not a real value
    class Node {
        public Node prev;//to access adjacent nodes in O(1) time
        public Node next;//to access adjacent nodes in O(1) time
        public int key;
        public int val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node!=null){
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node!=null){
            node.val = value;
            remove(node);
            add(node);
        } else {
            if(map.size() == capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
        }
    }
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private void add(Node node){
        Node oldFirstNode = head.next;
        //first node of list will be next of new node, making new node first
        node.next = oldFirstNode;
        //second node points newnode as previous
        oldFirstNode.prev = node;
        //first node previous is head
        node.prev = head;
        //so that head always provide this as first node
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */