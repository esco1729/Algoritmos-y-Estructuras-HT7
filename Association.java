// A class for binding key/value pairs.
// (c) 2007 duane a. bailey LIBRO DE TEXTO

import java.util.Map;

public class Association<K,V> implements MapEntry<K,V>{
    protected K theKey; // the key of the key-value pair
    protected V theValue; // the value of the key-value pair

    /**
    * Constructs a pair from a key and value.
    */
    public Association(K key, V value){
        theKey = key;
        theValue = value;
    }

    /**
    * Constructs a pair from a key; value is null.
    */
    public Association(K key){
        this(key,null);
    }

    /**
     * Standard comparison function.  Comparison based on keys only.
     */
    public boolean equals(Object other){
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    /**
     * Standard hashcode function.
     */
    public int hashCode(){
        return getKey().hashCode();
    }
    
    /**
     * Fetch value from association.  May return null.
    */
    public V getValue(){
        return theValue;
    }

    /**
     * Fetch key from association.  Should not return null.
     */
    public K getKey(){
        return theKey;
    }

    /**
     * Sets the value of the key-value pair.
     */
    public V setValue(V value){
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    /**
     * Standard string representation of an association.
     */
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("("+getKey()+","+getValue()+")");
        return s.toString();
    }
}