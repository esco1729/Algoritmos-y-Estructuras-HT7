public interface MapEntry<K,V>{
    public boolean equals (Object o);
    public K getKey();
    public V getValue();
    public int hashCode();
    public V setValue(V value);   
  }