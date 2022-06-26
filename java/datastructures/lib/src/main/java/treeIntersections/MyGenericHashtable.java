package treeIntersections;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyGenericHashtable {

  private ArrayList<LinkedList<MyBucketNode>> dataArray;

  private int capacity;

  private int itemsCount;

  private final int PRIME_MULTIPLIER = 599;

  public MyGenericHashtable() {
  }

  public MyGenericHashtable(int capacity) {
    this.capacity = capacity != 0 ? Math.abs(capacity) : 32;
    this.initializeArray();
  }

  protected void initializeArray() {
    this.dataArray = new ArrayList<>(this.capacity);

    for (int idx = 0; idx < capacity; idx++) {
      this.dataArray.add(new LinkedList<>());
    }
  }

  /**
   * Private helpter method hashes an input for use with this hashtable.
   *
   * @param words
   * @return
   */
  protected long sumChars(String words) {
    char[] wordCharacters = new char[words.length()];
    words.getChars(0, words.length(), wordCharacters, 0);
    long charCodeSum = 0;

    for (char character : wordCharacters) {
      charCodeSum = charCodeSum + Character.hashCode(character);
    }

    return charCodeSum;
  }

  /**
   * Takes a KEY and returns a hashed index for use with this hashtable.
   *
   * @param key
   * @return
   */
  protected int getHash(String key) {
    long charsProduct = sumChars(key);
    long primedCharsProduct = this.PRIME_MULTIPLIER * charsProduct;
    int hashedIndex = (int) (primedCharsProduct % this.capacity);
    return hashedIndex;
  }

  /**
   * Set method stores value at index K (hashedKey).
   */
  protected boolean add(String key, int value) {
    int hashedIndex = getHash(key);
    LinkedList<MyBucketNode> llTemp = null;

    try {
      llTemp = dataArray.get(hashedIndex);
      llTemp.add(new MyBucketNode(key, value));
//      dataArray.set(hashedIndex, llTemp);
      this.itemsCount++;
      return true;

    } catch (Exception ex) {
      System.out.println("Something went wrong attempting to store a value in LL bucket idx: " + hashedIndex);
    }

    return false;
  }

  /**
   * Take a key and return the value if found, otherwise return -1.
   * @param key
   * @return
   */
  protected int find(String key) {
    int hashedIndex = getHash(key);
    LinkedList<MyBucketNode> llTemp = null;
    llTemp = dataArray.get(hashedIndex);

    for(MyBucketNode mbn: llTemp) {
      if (mbn.getKey().equals(key)) {
        return mbn.getValue();
      }
    }

    return -1;
  }

  /**
   * Take a key and return true or false if the hashed key exists in the table.
   * @param key
   * @return
   */
  protected boolean contains(String key) {
    int result = this.find(key);

    return result != -1;
  }

  public ArrayList<LinkedList<MyBucketNode>> getDataArray() {
    return dataArray;
  }

  protected void setDataArray(ArrayList<LinkedList<MyBucketNode>> dataArray) {
    this.dataArray = dataArray;
  }

  public int getCapacity() {
    return capacity;
  }

  protected void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getItemsCount() {
    return itemsCount;
  }

  protected void setItemsCount(int itemsCount) {
    this.itemsCount = itemsCount;
  }

  public int getPRIME_MULTIPLIER() {
    return PRIME_MULTIPLIER;
  }
}
