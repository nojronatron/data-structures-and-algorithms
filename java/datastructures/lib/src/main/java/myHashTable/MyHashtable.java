package myHashTable;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashtable<T> {
  private ArrayList<LinkedList<NeighborhoodZipCode>> array;
  private int buckets = 0;
  private int items;

  // default constructor creates an empty hashtable with an initial capacity of 17
  public MyHashtable() {
    this.array = new ArrayList<LinkedList<NeighborhoodZipCode>>(11);
    this.buckets = 11;
    this.items = 0;
  }

  public MyHashtable(int capacity) {
    this.array = new ArrayList<LinkedList<NeighborhoodZipCode>>(Math.abs(capacity));
    this.buckets = Math.abs(capacity);
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

  public int getArray_size() {
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

    return -1;
  }
}
