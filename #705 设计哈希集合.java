class MyHashSet {

    private static final int BASE_VALUE=769;
    private LinkedList[] HashValueTable;

    /** Initialize your data structure here. */
    public MyHashSet() {
        HashValueTable=new LinkedList[BASE_VALUE];
        for(int i=0;i<BASE_VALUE;i++){
            HashValueTable[i]=new LinkedList<Integer>();
        }
    }
    
    public void add(int key) {
        int index=hash(key);
        Iterator<Integer> iterator=HashValueTable[index].iterator();
        while(iterator.hasNext()){
            Integer element =iterator.next();
            if(element==key){
                return;
            }
        }
        HashValueTable[index].addLast(key);
    }
    
    public void remove(int key) {
        int index=hash(key);
        Iterator<Integer> iterator=HashValueTable[index].iterator();
        while(iterator.hasNext()){
            Integer element=iterator.next();
            if(element==key){
                HashValueTable[index].remove(element);
                return;
            }
        }
        return ;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index=hash(key);
        Iterator<Integer> iterator=HashValueTable[index].iterator();
        while(iterator.hasNext()){
            Integer element=iterator.next();
            if(element==key)
                return true;
        }
        return false;
    }

    public int hash(int key){
        return key%BASE_VALUE;
    }
}

