// A class for structuring associations that may be compared.
// (c) 2007 duane a. bailey LIBRO DE TEXTO


import java.util.Map;

public class ComparableAssociation<K extends Comparable<K>,V> extends Association<K,V> implements Comparable<ComparableAssociation<K,V>>, MapEntry<K,V>{
    
    /**
     * Construct an association that can be ordered, from only a key.
     * The value is set to null.
     */
    public ComparableAssociation(K key){
        this(key,null);
    }

    /**
     * Construct a key-value association that can be ordered.
     */
    public ComparableAssociation(K key, V value){
        super(key,value);
    }

    /**
    * Determine the order of two comparable associations, based on key.
    */
    public int compareTo(ComparableAssociation<K,V> that){
        return this.getKey().compareTo(that.getKey());
    }

    /**
     * Construct a string representation of the ComparableAssociation.
     */
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("<ComparableAssociation: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}