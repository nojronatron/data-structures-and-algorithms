package myHashTable;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashtable<T> {
  private ArrayList<LinkedList<NeighborhoodZipCode>> array;
  private int buckets = 0; // raw capacity of the array
  private int items; // raw count of buckets with data in them
  private int primeMultiplier = 599;

  // default constructor creates an empty hashtable with an initial capacity of 11
  public MyHashtable() {
    this.buckets = 11;
    this.array = new ArrayList<LinkedList<NeighborhoodZipCode>>(buckets);
    this.items = 0;
  }

  public MyHashtable(int capacity) {
    this.buckets = Math.abs(capacity);
    this.array = new ArrayList<LinkedList<NeighborhoodZipCode>>(buckets);
    this.items = 0;
  }

  public float getLoadFactor() {
    return (float)items / (float)buckets;
  }

  public ArrayList<LinkedList<NeighborhoodZipCode>> getArray() {
    return array;
  }

  public void setArray(ArrayList<LinkedList<NeighborhoodZipCode>> array) {
    this.array = array;
  }

  public int getItemCount() {
    return this.array.size();
  }

  public Boolean set(String key, int value) {
    if (key.length() > 0 && value != 0) {
      // insert the new item into the Hash Table

      return true;
    }

    return false;
  }

  public int get(String key) {
    return -1;
  }

  public Boolean contains(String key) {
    return false;
  }

  public ArrayList<String> keys() {

    return new ArrayList<String>();
  }

  public Integer hash(String key) {
    // MUST use long to avoid roll-over in large number calculations
    long charsProduct = multiplyChars(key);
    Long primedCharsProduct = primeMultiplier * charsProduct;
    int hashedIndex = (int) (primedCharsProduct % this.buckets);
    return hashedIndex;
  }

  private long multiplyChars(String words) {
    char[] wordCharacters = new char[words.length()];
    words.getChars(0, words.length(), wordCharacters, 0);
    int charCodeProduct = 1;

    for(char character: wordCharacters) {
      charCodeProduct = charCodeProduct * Character.hashCode(character);
    }

    return charCodeProduct;
  }
}
