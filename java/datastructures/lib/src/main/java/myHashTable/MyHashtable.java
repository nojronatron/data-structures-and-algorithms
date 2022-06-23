package myHashTable;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashtable<T> {
  /**
   * array is the internal data-store backing this hash table that relies on linked lists for chaining
   */
  private ArrayList<LinkedList<NeighborhoodZipCode>> dataArray;

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
    this.dataArray = new ArrayList<LinkedList<NeighborhoodZipCode>>(buckets);
    this.items = 0;
    initializeArray();
  }

  /**
   * single-param constructor allows setting hashtable starting capacity
   * @param capacity
   */
  public MyHashtable(int capacity) {
    this.buckets = Math.abs(capacity);
    this.dataArray = new ArrayList<LinkedList<NeighborhoodZipCode>>(buckets);
    this.items = 0;
    initializeArray();
  }

  private void initializeArray() {
    for (int idx=0; idx < this.buckets; idx++) {
      dataArray.add(new LinkedList<NeighborhoodZipCode>());
    }
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
  public ArrayList<LinkedList<NeighborhoodZipCode>> getDataArray() {
    return dataArray;
  }

  /**
   * Allows setting the backing array of this hash table
   * @param dataArray
   */
  public void setDataArray(ArrayList<LinkedList<NeighborhoodZipCode>> dataArray) {
    this.dataArray = dataArray;
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

      // check to return fast
      if (this.contains(key)) {
        return true;
      }

      // insert the new item into the Hash Table
      int hashedIndex = this.hash(key);
      LinkedList<NeighborhoodZipCode> tempLL = null;

      try {
        // boolean hasData = this.dataArray.get(hashedIndex) != null; // array.get does not accept a long
        tempLL = this.dataArray.get(hashedIndex);
        tempLL.add(new NeighborhoodZipCode(key, value));
        // this.dataArray.add(tempLL);
        this.items ++;
        return true;
      } catch (Exception ex) {
        // TODO: Add a logging mechanism
        System.out.println("Could not get data structure from hashcode " + hashedIndex + ", error:" + ex.getMessage());
      }
    }

    return false;
  }

  /**
   * Accepts a string key and returns the value (zip code here) if found otherwise -1 (failed to find).
   * @param key
   * @return
   */
  public int get(String key) {
    int hashedIndex = this.hash(key);

    try {
      boolean hasData = this.dataArray.get(hashedIndex) != null; // array.get does not accept a long
      LinkedList<NeighborhoodZipCode> tempLL = this.dataArray.get(hashedIndex);

      for (int idx=0; idx <= tempLL.size(); idx++) {

        NeighborhoodZipCode nzc = tempLL.get(idx);

        if (nzc.get_neighborhood().equals(key)) {
          return nzc.get_zipCode();
        }
      }
    } catch (Exception ex) {
      System.out.println("There is no item at index " + hashedIndex + ", error: " + ex.getMessage());
    }

    return -1;
  }

  /**
   * Returns True if the key is found in this hashtable, otherwise returns False.
   * @param key
   * @return
   */
  public Boolean contains(String key) {
    return this.get(key) != -1;
  }

  /**
   * Locates all keys (Strings) in hash table and returns them as an ArrayList.
   * @return
   */
  public ArrayList<String> keys() {
    ArrayList<String> allKeys = new ArrayList<String>();

    for (int idx=0; idx < this.buckets; idx++) {
      LinkedList<NeighborhoodZipCode> currentBucket = this.dataArray.get(idx);

      if (currentBucket.size() > 0) {
        getBucketAsArray(allKeys, currentBucket);
      }
    }

    return allKeys;
  }

  /**
   * Updates Strings array if currentBucket has stored items in it.
   * @param strings
   * @param currentBucket
   */
  private void getBucketAsArray(ArrayList<String> strings, LinkedList<NeighborhoodZipCode> currentBucket) {
    if (currentBucket.size() == 0) {
      return;
    }

    for (NeighborhoodZipCode neighborhoodZipCode : currentBucket) {
      strings.add(neighborhoodZipCode.get_neighborhood());
    }
  }

  /**
   * Takes a KEY and returns hashed index for use within this hashtable.
   * @param key
   * @return
   */
  public int hash(String key) {
    // MUST use long to avoid roll-over in large number calculations
    long charsProduct = multiplyChars(key);
    long primedCharsProduct = primeMultiplier * charsProduct;
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
    long charCodeProduct = 1;

    for(char character: wordCharacters) {
      charCodeProduct = charCodeProduct + Character.hashCode(character);
    }

    return charCodeProduct;
  }
}
