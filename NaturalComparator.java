// A comparator that implements the natural ordering.
// (c) 2007 duane a. bailey LIBRO DE TEXTO

import java.util.Comparator;


public class NaturalComparator<E extends Comparable<E>> implements Comparator<E>{
    /*
     * Compare two values, a and b.  Simply calls the default
     * compareTo method for a on b.
     */
    public int compare(E a, E b){
        return a.compareTo(b);
    }

    /*
     * Returns true if the other object is a NaturalComparator.
     */
    public boolean equals(Object b){
        return (b != null) && (b instanceof NaturalComparator);
    }
}