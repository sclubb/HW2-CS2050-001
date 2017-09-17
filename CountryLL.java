/*
 * Steven Clubb 
 * 9/8/2017
 * CS 2050
 */
package hw2;

/**
 * This class is used to create a linked list of countries and their corresponding data.
 */
public class CountryLL {
    
    
    public CountryLL next;
    public Countries country;
    
    //This creates the linkedlist
    public CountryLL(Countries _country){
        this.country = _country;
        this.next = null;
    }
    
    /// Create new LL node and point Next to this LL node, return new LL node
    public CountryLL add(Countries _country){
        
        CountryLL item = new CountryLL(_country);
        item.next = this;
        return item;
    }
    
    public int countItems(){
        
        return count(this, 0);
    }
    /**
     * Counts how long the Linkedlist is to find how big the array needs to be
     * @param item
     * @param _count
     * @return 
     */
     private int count(CountryLL item, int _count){
         
         _count++; 
         if(item.next == null){
             return _count;
         }
         else{
             return count(item.next, _count);
         }
         
     }
    
}
