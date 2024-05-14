public class MyHashTable <K, V>{
    public HashNode<K, V>[] chainArray;
    private int M = 11; // Capacity
    private int size;
    public MyHashTable(){ // Creating constructor
        chainArray = new HashNode[M];
    };
    public MyHashTable(int M){ // Creating constructor with capacity
        this.M = M;
        chainArray = new HashNode[M];
    };
    private int hash(K key) {
        return key.hashCode() % M; // Using formula to find index in hash table
    };
    public void put(K key, V value) {
        int index = hash(key); // finding index
        HashNode<K, V> newNode = new HashNode<>(key, value); // creating new node

        if(chainArray[index] == null){ // checking is index empty
            chainArray[index] = newNode; // placing node there
            size++; // increasing size
        } else { // if index not empty it is collision
            HashNode<K, V> current = chainArray[index];  // initializing current variable
            while(current.next != null){  // iterate through linked list
                current = current.next;
            }
            current.next = newNode; // and add node to the end
            size++; // increase size
        }
    };
    public V get(K key) {
        int index = hash(key); // get index

        HashNode<K, V> current = chainArray[index]; // initialize node at this index
        while(current != null){ // iterate
            if(current.key.equals(key)){ // check if key matches value
                return current.value; // return if yes
            }
            current = current.next;
        }

        return null; // no value case
    };
    public V remove(K key) {
        int index = hash(key); // get index

        HashNode<K, V> current = chainArray[index];  // initialize node at this index
        HashNode<K, V> prev = null; // track prev node

        while(current != null){ // searching for
            if(current.key.equals(key)){
                if(prev == null){ // if prev is null, first node in chain is wil be removed
                    chainArray[index] = current.next;
                } else { // if not
                    prev.next = current.next; // node we are looking for is in the middle or end of the chain
                }
                size--; // decrease size
                return current.value; // value of the removed node is returned
            }
            prev = current; // move to the next if not match
            current = current.next;
        }

        return null;
    };
    public boolean contains(V value) {
        for(int i = 0; i < M; i++){ // iterate through chainArray
            HashNode<K, V> current = chainArray[i]; // for each index initialize current
            while(current != null){ // iterate
                if(current.value.equals(value)){ // If find such value return true
                    return true;
                }
                current = current.next; // move next
            }
        }

        return false; // no value case
    };
    public K getKey(V value) {
        for(int i = 0; i < M; i++){ // iterate through chainArray
            HashNode<K, V> current = chainArray[i]; // for each index initialize current
            while(current != null){
                if(current.value.equals(value)){ // If find such value
                    return current.key; // return key
                }
                current = current.next; // move next
            }
        }

        return null; // no key case
    };

}
