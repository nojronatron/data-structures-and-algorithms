package myHashTable;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashtable<T> {
  /**
   * array is the internal data-store backing this hash table that relies on linked lists for chaining
   */
  private ArrayList<LinkedList<NeighborhoodZipCode>> array;

  /**
   * The number of buckets (raw capacity) of the backing array
   */
  private int buckets = 0; // raw capacity of the array

  /**
   * Count of the number of times items have been added, minus the numer of times items have been removed.
   */
  private int items; // raw count of buckets with data in them

  /**
   * primeMultiplier is a prime int used in the hash() function
   */
  private int primeMultiplier = 599;

  /**
   * default constructor creates an empty hashtable with an initial capacity of 11
   */
  public MyHashtable() {
    this.buckets = 11;
    this.array = new ArrayList<LinkedList<NeighborhoodZipCode>>(buckets);
    this.items = 0;
  }

  /**
   * single-param constructor allows setting hashtable starting capacity
   * @param capacity
   */
  public MyHashtable(int capacity) {
    this.buckets = Math.abs(capacity);
    this.array = new ArrayList<LinkedList<NeighborhoodZipCode>>(buckets);
    this.items = 0;
  }

  /**
   * Load Factor is the number of items divided by the number of buckets
   * A load factor over 1.0 could indicate a congested hash table with many collisions, reducing performance
   * @return
   */
  public float getLoadFactor() {
    return (float)items / (float)buckets;
  }

  /**
   * Returns the backing array of this hash table
   * @return
   */
  public ArrayList<LinkedList<NeighborhoodZipCode>> getArray() {
    return array;
  }

  /**
   * Allows setting the backing array of this hash table
   * @param array
   */
  public void setArray(ArrayList<LinkedList<NeighborhoodZipCode>> array) {
    this.array = array;
  }

  /**
   * Returns the total number of times items have been added to this hash table minus the number than have been removed.
   * @return
   */
  public int getItemCount() {
    return this.items;
  }

  /**
   * Adds an item to the hash table.
   * @param key
   * @param value
   * @return
   */
  public Boolean set(String key, int value) {
    if (key.length() > 0 && value != 0) {
      // insert the new item into the Hash Table
      int hashcode = this.hash(key);
      boolean hasData = this.array.get(hashcode) != null;
      LinkedList<NeighborhoodZipCode> tempLL = null;

      if (!hasData) {
        tempLL = new LinkedList<NeighborhoodZipCode>();
      } else {
        tempLL = this.array.get(hashcode);
      }

      tempLL.add(new NeighborhoodZipCode(key, value));
      this.array.add(tempLL);
      this.items ++;
      return true;
    }

    return false;
  }

  /**
   * TODO: Implement => Returns the Value stored at KEY.
   * @param key
   * @return
   */
  public int get(String key) {
    return -1;
  }

  /**
   * TODO: Implement => Returns Boolean representing whether a KEY can be found in this hashtable.
   * @param key
   * @return
   */
  public Boolean contains(String key) {
    return false;
  }

  /**
   * TODO: Implement => returns unique list of all KEYS within this hashtable.
   * @return
   */
  public ArrayList<String> keys() {

    return new ArrayList<String>();
  }

  /**
   * Takes a KEY and returns hash of type Integer for use within this hashtable.
   * @param key
   * @return
   */
  public Integer hash(String key) {
    // MUST use long to avoid roll-over in large number calculations
    long charsProduct = multiplyChars(key);
    Long primedCharsProduct = primeMultiplier * charsProduct;
    int hashedIndex = (int) (primedCharsProduct % this.buckets);
    return hashedIndex;
  }

  /**
   * Private helper method does the hashing math.
   * @param words
   * @return
   */
  private long multiplyChars(String words) {
    // private method handles calculation of strings to a hash of type primitive long
    char[] wordCharacters = new char[words.length()];
    words.getChars(0, words.length(), wordCharacters, 0);
    int charCodeProduct = 1;

    for(char character: wordCharacters) {
      charCodeProduct = charCodeProduct * Character.hashCode(character);
    }

    return charCodeProduct;
  }
}
