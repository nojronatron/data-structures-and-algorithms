package simpleStringHashTable;

import java.util.ArrayList;

public class SimpleStringHashTable {

  private ArrayList<String> stringArray;

  private int capacity;

  private int itemsCount;

  private int primeMultiplier = 599;

  public SimpleStringHashTable() {
    this.capacity = 11;
    stringArray = new ArrayList<>(capacity);
  }

  public SimpleStringHashTable(int capacity) {
    stringArray = new ArrayList<>(capacity);
    this.capacity = capacity;
  }

  public ArrayList<String> getStringArray() {
    return stringArray;
  }

  public void setStringArray(ArrayList<String> stringArray) {
    this.stringArray = stringArray;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getItemsCount() {
    return itemsCount;
  }

  public void setItemsCount(int itemsCount) {
    this.itemsCount = itemsCount;
  }

  public float getLoadFactor() {
    return (float) this.itemsCount / (float) this.capacity;
  }

  public String repeatedWord(String string) {
    if (string.length() <= 1) {
      return "";
    }

    String delimiters = "\\s,\\W";
    String[] wordList = string.split(delimiters);

    if (wordList.length < 2 ) {
      return string;
    }

    for(String word: wordList){

    }

    return "";
  }

  /**
   * Takes a KEY and returns a hashed index for use with this hashtable.
   * @param key
   * @return
   */
  public int hash(String key) {
    long charsProduct = sumChars(key);
    long primedCharsProduct = this.primeMultiplier * charsProduct;
    int hashedIndex = (int) (primedCharsProduct % this.capacity);
    return hashedIndex;
  }

  /**
   * Private helpter method hashes an input for use with this hashtable.
   * @param words
   * @return
   */
  private long sumChars(String words) {
    char[] wordCharacters = new char[words.length()];
    words.getChars(0, words.length(), wordCharacters, 0);
    long charCodeSum = 0;

    for(char character: wordCharacters) {
      charCodeSum = charCodeSum + Character.hashCode(character);
    }

    return charCodeSum;
  }
}
