package myHashTable;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class myHashTablePackageTests {

  protected static ArrayList<NeighborhoodZipCode> sampleDataList = null;

  private static void instantiateSampleData() {
    sampleDataList = new ArrayList<>();
    sampleDataList.add(new NeighborhoodZipCode("Renton", 98055));
    sampleDataList.add(new NeighborhoodZipCode("Capitol Hill", 98102));
    sampleDataList.add(new NeighborhoodZipCode("Greenwood", 98103));
    sampleDataList.add(new NeighborhoodZipCode("Greenlake", 98103));
    sampleDataList.add(new NeighborhoodZipCode("Pioneer Square", 98104));
    sampleDataList.add(new NeighborhoodZipCode("University District", 98105));
    sampleDataList.add(new NeighborhoodZipCode("Columbia City", 98118));
    sampleDataList.add(new NeighborhoodZipCode("Bellevue", 98005));
    sampleDataList.add(new NeighborhoodZipCode("Seattle", 98101));
    sampleDataList.add(new NeighborhoodZipCode("Mercer Island", 98040));
    sampleDataList.add(new NeighborhoodZipCode("Alki Beach", 98116));
    sampleDataList.add(new NeighborhoodZipCode("Northgate", 98125));
    sampleDataList.add(new NeighborhoodZipCode("Downtown", 98101));
    sampleDataList.add(new NeighborhoodZipCode("Laurelhurst", 98105));
    sampleDataList.add(new NeighborhoodZipCode("Bainbridge Island", 98110));
    sampleDataList.add(new NeighborhoodZipCode("Magnolia", 98199));
    sampleDataList.add(new NeighborhoodZipCode("Kirkland", 98033));
    sampleDataList.add(new NeighborhoodZipCode("Lynnwood", 98037));
    sampleDataList.add(new NeighborhoodZipCode("Ballard", 98107));
    sampleDataList.add(new NeighborhoodZipCode("Queen Anne", 98109));
    sampleDataList.add(new NeighborhoodZipCode("West Seattle", 98116));
    sampleDataList.add(new NeighborhoodZipCode("International District", 98104));
    sampleDataList.add(new NeighborhoodZipCode("Mount Baker", 98144));
    sampleDataList.add(new NeighborhoodZipCode("Redmond", 98052));
    sampleDataList.add(new NeighborhoodZipCode("Freemont", 98103));
    sampleDataList.add(new NeighborhoodZipCode("South Lake Union", 98109));
    sampleDataList.add(new NeighborhoodZipCode("Madrona", 98110));
    sampleDataList.add(new NeighborhoodZipCode("Belltown", 98121));
    sampleDataList.add(new NeighborhoodZipCode("Madison Park", 98112));
  }

  @Test
  void testMyhashtableCanBeInstantiated() {
    // Tests Naked instantiation
    int expectedCount = 0;

    MyHashtable<NeighborhoodZipCode> sut = new MyHashtable();

    assertNotNull(sut);
    assertEquals(expectedCount, sut.getItemCount(),
      "Default constructor instantiates a hashtable with a zero-count of items stored.");
  }

  @Test
  void testSettingKeyValueToHashtableResultsInValueBeingInTheDataStructure() {
    // Tests hashtable.SET(key, value)
    NeighborhoodZipCode expectedData = new NeighborhoodZipCode("Madison Park", 98112);
    MyHashtable<NeighborhoodZipCode> sut = new MyHashtable();

    sut.set(expectedData.get_neighborhood(), expectedData.get_zipCode());
    int actualData = sut.get("Madison Park");

    assertEquals(expectedData.get_zipCode(), actualData);
  }

  @Test
  void testRetrieveBasedOnKeyReturnsValueStored() {
    // Tests hashtable.GET(key)
    NeighborhoodZipCode expectedData = new NeighborhoodZipCode("Madison Park", 98112);

    MyHashtable<NeighborhoodZipCode> sut = new MyHashtable<>();
    sut.set(expectedData.get_neighborhood(), expectedData.get_zipCode());

    int actualResult = sut.get("Madison Park");

    assertTrue(sut.getItemCount() > 0);
    assertEquals(expectedData.get_zipCode(), actualResult, "Get(Madison Park) should return Integer 98112.");
  }

  @Test
  void testReturnsFalseForKeyThatDoesNotExistInHashtable() {
    // Test: hashtable.contains(key) returns FALSE if NOT IN hashtable
    sampleDataList = new ArrayList<>();
    sampleDataList.add(new NeighborhoodZipCode("Renton", 98055));
    sampleDataList.add(new NeighborhoodZipCode("Capitol Hill", 98102));
    sampleDataList.add(new NeighborhoodZipCode("Greenwood", 98103));

    String lookupKey = "West Seattle";

    MyHashtable<NeighborhoodZipCode> sut = new MyHashtable<>();
    for(NeighborhoodZipCode nzc: sampleDataList) {
      sut.set(nzc.get_neighborhood(), nzc.get_zipCode());
    }

    boolean actualResult = sut.contains(lookupKey);

    assertTrue(sut.getItemCount() > 0, "There are 1 or more items in this Hashtable.");
    assertFalse(actualResult, "West Seattle is not be in this hashtable.");
  }

  @Test
  void testReturnsListOfAllUniqueKeysThatExistInHashtable() {
    // Test: Hashtable.keys() returns list of UNIQUE KEYS only

    // load table with some duplicate data
    sampleDataList = new ArrayList<>();
    sampleDataList.add(new NeighborhoodZipCode("Downtown", 98101));
    sampleDataList.add(new NeighborhoodZipCode("Laurelhurst", 98105));
    sampleDataList.add(new NeighborhoodZipCode("Bainbridge Island", 98110));
    sampleDataList.add(new NeighborhoodZipCode("Magnolia", 98199));
    sampleDataList.add(new NeighborhoodZipCode("Downtown", 98101));
    sampleDataList.add(new NeighborhoodZipCode("Laurelhurst", 98105));
    sampleDataList.add(new NeighborhoodZipCode("Bainbridge Island", 98110));
    sampleDataList.add(new NeighborhoodZipCode("Magnolia", 98199));
    sampleDataList.add(new NeighborhoodZipCode("Kirkland", 98033));

    int expectedItemCount = 5; // there are no duplicates by sut design

    MyHashtable<NeighborhoodZipCode> sut = new MyHashtable<>();
    for(NeighborhoodZipCode nzc: sampleDataList) {
      sut.set(nzc.get_neighborhood(), nzc.get_zipCode());
    }

    int actualItemCount = sut.getItemCount();

    assertEquals(expectedItemCount, actualItemCount,
      "An unexpected number of items were loaded into the hashtable but uniqueness is guaranteed.");

    // set up expected results array to confirm correct items have been loaded and are unique
    ArrayList<String> expectedResults = new ArrayList<>();
    expectedResults.add("Downtown");
    expectedResults.add("Laurelhurst");
    expectedResults.add("Bainbridge Island");
    expectedResults.add("Magnolia");
    expectedResults.add("Kirkland");

    ArrayList<String> actualResults = sut.keys();

    expectedItemCount = 5;
    actualItemCount = actualResults.size();

    assertEquals(expectedItemCount, actualItemCount,
      "There should only be unique values stored in the hash table despite adding duplicates.");

    // test that values are there
    for(String actual: actualResults) {
      assertTrue(expectedResults.contains(actual), "Item should be in the expected items array list.");
    }

    // test for only unique values by comparing size of array before and after calling built-in distinct
    long uniqueCount = actualResults.size(); // leverage upcasting here because distinct().count() returns a long
    Stream<String> distinctItems = actualResults.stream().distinct();
    long distinctCount = distinctItems.count();
    assertEquals(uniqueCount, distinctCount);
  }

  @Test
  void testHandlesCollisionWithinHashtable() {
    // Test: hashtable.SET(k, v) handles COLLISIONS

    // load list with some collision-likely data
    instantiateSampleData();
    MyHashtable<NeighborhoodZipCode> sut = new MyHashtable<>();

    for(NeighborhoodZipCode nhz: sampleDataList) {
      sut.set(nhz.get_neighborhood(), nhz.get_zipCode());
    }

    int expectedCount = sampleDataList.size();
    int actualCount = sut.getItemCount();

    assertEquals(expectedCount, actualCount,
      "The expected number of items should have been added to the hash table despite collisions.");
    assertTrue(sut.getLoadFactor() > 1);
  }

  @Test
  void testRetrieveValueFromBucketWithinHashtable_WithCollision() {
    // Test: hashtable.GET(k) handles COLLISIONS and RETURNS CORRECT VALUE

    // load list with some collision-likely data
    instantiateSampleData();
    MyHashtable<NeighborhoodZipCode> sut = new MyHashtable<>();

    for(NeighborhoodZipCode nhz: sampleDataList) {
      sut.set(nhz.get_neighborhood(), nhz.get_zipCode());
    }

    int expectedResult = 98144;
    int actualResult = sut.get("Mount Baker");

    assertTrue(sut.getLoadFactor() > 1,
      "Load factor should be greater than one to ensure collisions exist.");
    assertEquals(expectedResult, actualResult,
      "Key Mount Baker should return 98144 even when load factor is greater than 1 (there are collisions).");
  }

  @Test
  void testCanHashAKeyToAnInRangeValue() {
    // Test: Hashtable.HASH(k) returns INTEGER IN RANGE OF TABLE SIZE
    int expectedResultMustBeLessThan = 5;

    MyHashtable<NeighborhoodZipCode> sut = new MyHashtable<>(expectedResultMustBeLessThan);

    long actualResult = sut.hash("abcde");

    assertTrue(0 < actualResult);
    assertTrue(actualResult < expectedResultMustBeLessThan);
  }
}
