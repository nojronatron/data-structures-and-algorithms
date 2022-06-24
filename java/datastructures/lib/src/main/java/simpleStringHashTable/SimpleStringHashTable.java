package simpleStringHashTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class SimpleStringHashTable {

  private ArrayList<LinkedList<String>> dataArray;

  private int capacity;

  private int itemsCount;

  private int primeMultiplier = 599;

  public SimpleStringHashTable() {
  }

  public SimpleStringHashTable(int capacity) {
    this.capacity = capacity;
    initializeArray();
  }

  private void initializeArray() {
    this.dataArray = new ArrayList<>(this.capacity);

    for(int idx=0; idx < capacity; idx++) {
      this.dataArray.add(new LinkedList<>());
    }
  }

  /**
   * Adds strings to a hashmap and returns the first duplicate string it encounters.
   * @param string
   * @return String
   */
  public String repeatedWord(String string) {
    if (string.isEmpty() || string.length() == 1) {
      return "";
    }

    String delimiters = "\\W";
    String[] wordList = string.split(delimiters);

    if (wordList.length < 2) {
      return "";
    }

    this.capacity = wordList.length;
    this.initializeArray();

    for (String word : wordList) {
      String lcWord = word.toLowerCase(Locale.ROOT);
      int hashedIdx = this.hash(lcWord);
      LinkedList<String> tempLL = null;

      try {
        tempLL = this.dataArray.get(hashedIdx);
        if (tempLL.contains(lcWord)) {
          return word;
        } else {
          tempLL.add(lcWord);
          this.itemsCount++;
        }
      } catch (Exception ex) {
        // TODO: Add a logging mechanism
        System.out.println("Friendly error message: Something went wrong while checking for duplicates in a bucket.");
      }
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
  protected long sumChars(String words) {
    char[] wordCharacters = new char[words.length()];
    words.getChars(0, words.length(), wordCharacters, 0);
    long charCodeSum = 0;

    for(char character: wordCharacters) {
      charCodeSum = charCodeSum + Character.hashCode(character);
    }

    return charCodeSum;
  }

}
