class LRUCache {
    private Map<Integer, DLinkedNode> hashIndex = new HashMap<>();
    private int size, capacity;
    // head,tail是两个空节点,便于节点操作一致性
    private DLinkedNode head, tail;

    class DLinkedNode {
        int key, value;
        DLinkedNode prev, next;

        public DLinkedNode() {
        };

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = hashIndex.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = hashIndex.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        } else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            hashIndex.put(key, newNode);
            addToHead(newNode);
            size++;
            /*
             * 当缓存容量达到上限时 它应该在写入新数据之前删除最久未使用的数据值 从而为新的数据值留出空间
             */
            if (size > capacity) {
                // 这里tail是局部变量,不是类变量tail,访问类tail用this.
                DLinkedNode tail;
                tail = removeTail();
                hashIndex.remove(tail.key);
                size--;
            }
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
