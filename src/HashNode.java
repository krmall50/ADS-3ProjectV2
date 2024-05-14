public class HashNode <K, V>{
    private K key;
    private V value;
    public HashNode<K, V> next;
    public HashNode(K key, V value){
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString(){
        return "{" + key + " " + value + "}";
    }
}
