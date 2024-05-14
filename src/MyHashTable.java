public class MyHashTable <K, V>{
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable(){
        chainArray = new HashNode[M];
    };
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
    };
    private int hash(K key) {
        return key.hashCode() % M;
    };
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if(chainArray[index] == null){
            chainArray[index] = newNode;
            size++;
        } else {
            HashNode<K, V> current = chainArray[index];
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    };
    public V get(K key) {
        int index = hash(key);

        HashNode<K, V> current = chainArray[index];
        while(current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }

        return null;
    };
    //public V remove(K key) {};
    //public boolean contains(V value) {};
    public K getKey(V value) {
        for(int i = 0; i < M; i++){
            HashNode<K, V> current = chainArray[i];
            while(current != null){
                if(current.value.equals(value)){
                    return current.key;
                }
                current = current.next;
            }
        }

        return null;
    };

}
